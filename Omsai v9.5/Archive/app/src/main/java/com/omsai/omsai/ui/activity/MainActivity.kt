package com.omsai.omsai.ui.activity

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.omsai.omsai.App
import com.omsai.omsai.R
import com.omsai.omsai.ui.adapter.RecyclerAdapter
import com.omsai.omsai.ui.viewmodel.MyViewModel
import com.omsai.omsai.db.Photo
import com.omsai.omsai.utils.PrintingUtils
import com.omsai.omsai.service.*
import com.omsai.omsai.utils.SessionManager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), RecyclerAdapter.ClickListener {
    private val ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners"
    private val SETTINGS_NOTIF_LISTENER = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
    private var mPackageName: String? = null
    private lateinit var adapter: RecyclerAdapter
    var photosList: List<Photo> = ArrayList()
    var isFilter = false
    var date = Date()

    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = getString(R.string.app_name)
        mPackageName = packageName
        setupUI()
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        bind(viewModel)
        App.wake?.acquire()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    override fun onResume() {
        super.onResume()
        updateNotifAccessView(hasNotifAccessPermission())
        checkService(EndlessService.isServiceStarted)
        if (EndlessService.isServiceStarted) actionOnService(Actions.START)
    }

    private fun setupUI() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(ArrayList(), this@MainActivity)
        recyclerView?.adapter = adapter

        requestNotifAccess.setOnClickListener {
            requestNotifAccess()
        }

        btnStartService.setOnClickListener {
            startServiceAction()
        }

        btnStopService.setOnClickListener {
            log("STOP THE printing SERVICE ON DEMAND")
            actionOnService(Actions.STOP)
            viewModel.markAllASPrint()
            checkService(false)
        }

        tvCnt.setOnClickListener {
            markASPrint()
        }

        btPrint.setOnClickListener {
            runBlocking {
                btPrint.text = "Printing"
                var x = adapter.getList()
                x.filter { it.IsChecked }.forEach {
                    delay(1500)
                    onLongItemClick(it)
                }.run {
                    btPrint.text = "Print"
                    adapter.resetSelection()
                }

            }
        }

        btReset.setOnClickListener {
            adapter.resetSelection()
        }

        btselectAll.setOnClickListener {
            adapter.selectAll()
        }
/*
        btFilter.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c[Calendar.YEAR]
            val month = c[Calendar.MONTH]
            val day = c[Calendar.DAY_OF_MONTH]
            DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                isFilter = true
                date = Date(selectedYear, selectedMonth, selectedDay)
                if (isFilter) adapter.setData(photosList.filter {
                    viewModel.getDate(it.time).let { d ->
                        d.year == date.year && d.month == date.month && d.day == date.day
                    }
                })

            }, year, month, day).show()
        }*/
    }

    private fun bind(viewModel: MyViewModel) {
        var today = Date()
        viewModel.getUsers()?.observe(this, Observer<List<Photo>> { pic ->
            updateCount()
            photosList = pic
            tvCnt.text = "Today Items : " + pic.filter {
                viewModel.getDate(it.time).let { d ->
                    d.year == today.year && d.month == today.month && d.day == today.day
                }
            }.size + "   Pending Items : " + pic.count { !it.isPrinted }

            adapter.getList().filter { it.IsChecked }.forEach { x ->
                pic.find { it.filePath == x.filePath && it.fileName == x.fileName && it.msg == x.msg }?.IsChecked = x.IsChecked
            }

            if (isFilter) adapter.setData(pic.filter {
                viewModel.getDate(it.time).let { d ->
                    d.year == date.year && d.month == date.month && d.day == date.day
                }
            }) else adapter.setData(pic)

        })
    }


    override fun onCheckAction(photos: List<Photo>) {
        if (photos.filter { it.IsChecked }.isNotEmpty()) {
            btReset.isEnabled = true
            btPrint.isEnabled = true
        } else {
            btReset.isEnabled = false
            btPrint.isEnabled = false
        }
    }


    override fun onLongItemClick(photo: Photo) {
        viewModel.print(photo, object : PrintingUtils.PrintJob {
            override fun OnSuccessful() {
                GlobalScope.launch(Dispatchers.Default) {
                    photo.isPrinted = true
                    App.getDatabase()?.daoPhoto()?.insert(photo)
                    updateCount()
                }
            }

            override fun OnFail() {
            }
        })
    }

    override fun onItemClick(photo: Photo) {
        startActivity(DetailTextActivity.getIntent(this@MainActivity, photo))
    }

    private fun requestNotifAccess() {
        runOnUiThread {
            Toast.makeText(this@MainActivity, getString(R.string.request_notif_access), Toast.LENGTH_SHORT).show()
            startActivity(Intent(SETTINGS_NOTIF_LISTENER))
        }
    }


    private fun checkService(flag: Boolean) {
        // btnSetupPrinter.visibility = View.GONE

        if (flag) {
            btnStartService.visibility = View.GONE
            btnStopService.visibility = View.VISIBLE
        } else {
            btnStartService.visibility = View.VISIBLE
            btnStopService.visibility = View.GONE
        }
    }


    private fun actionOnService(action: Actions) {
        checkService(true)
        if (getServiceState(this) == ServiceState.STOPPED && action == Actions.STOP) return
        Intent(this, EndlessService::class.java).also {
            it.action = action.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                log("Starting the service in >=26 Mode")
                startForegroundService(it)
              //  SessionManager.setPrintCount(0)
                return
            }
            log("Starting the service in < 26 Mode")/*ð*/
            startService(it)
        }
    }

    private fun hasNotifAccessPermission(): Boolean {
        val contentResolver = contentResolver
        val listeners = Settings.Secure.getString(contentResolver, ENABLED_NOTIFICATION_LISTENERS)
        return listeners != null && listeners.contains(mPackageName!!)
    }

    private fun updateNotifAccessView(isAccessEnabled: Boolean) {
        runOnUiThread { requestNotifAccess.visibility = if (isAccessEnabled) View.GONE else View.VISIBLE }
    }

    private fun startServiceAction() {
        updateCount()
        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        log("START THE FOREGROUND SERVICE ON DEMAND")
                        actionOnService(Actions.START)
                        val launchIntent = packageManager.getLaunchIntentForPackage("com.guibais.whatsauto")
                        launchIntent?.let { startActivity(it) }
                        updateCount()
                    }

                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        toast("Please allow all permission")
                    }

                    override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, token: PermissionToken?) {
                        token?.continuePermissionRequest()
                    }
                })
                .withErrorListener {
                    toast(it.name)
                }
                .check()
    }


    private fun markASPrint() {
        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    Dexter.withContext(this)
                            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            .withListener(object : PermissionListener {
                                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                                    viewModel.markAllASPrint()

                                }

                                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                                    toast("Please allow all permission")
                                }

                                override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, token: PermissionToken?) {
                                    token?.continuePermissionRequest()
                                }
                            })
                            .withErrorListener {
                                toast(it.name)
                            }
                            .check()

                    dialog.dismiss()
                }
                DialogInterface.BUTTON_NEGATIVE -> {
                    dialog.dismiss()
                }
            }
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mark all photos are printed").setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show()
    }

    fun updateCount(){
        btnStartService.setText("Start Printing Service  #${SessionManager.getPrintCount()} ==  #${SessionManager.getPrintCountT()}")
        btnStopService.setText("Stop Printing Service  #${SessionManager.getPrintCount()}  == #${SessionManager.getPrintCountT()}")
    }
}
