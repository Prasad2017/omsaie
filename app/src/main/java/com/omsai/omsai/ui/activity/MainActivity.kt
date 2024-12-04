package com.omsai.omsai.ui.activity

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
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
import com.omsai.omsai.databinding.ActivityMain2Binding
import com.omsai.omsai.db.Photo
import com.omsai.omsai.service.Actions
import com.omsai.omsai.service.EndlessService
import com.omsai.omsai.service.ServiceState
import com.omsai.omsai.service.getServiceState
import com.omsai.omsai.ui.adapter.RecyclerAdapter
import com.omsai.omsai.ui.viewmodel.MyViewModel
import com.omsai.omsai.utils.PrintingUtils
import com.omsai.omsai.utils.SessionManager
import com.omsai.omsai.utils.SingleActionListener
import com.omsai.omsai.utils.log
import com.omsai.omsai.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Date


class MainActivity : AppCompatActivity(), RecyclerAdapter.ClickListener {
    private val ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners"
    private val SETTINGS_NOTIF_LISTENER = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
    private var mPackageName: String? = null
    private lateinit var adapter: RecyclerAdapter
    var photosList: List<Photo> = ArrayList()
    var isFilter = false
    var date = Date()
    private lateinit var binding: ActivityMain2Binding

    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view: View =
            binding.getRoot() //Root xml or viewGroup will be a part of converted view over here
        setContentView(view)
        mPackageName = packageName
        setupUI()
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        bind(viewModel)
        App.wake?.acquire()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    }

    override fun onResume() {
        super.onResume()
        updateNotifAccessView(hasNotifAccessPermission())
        checkService(EndlessService.isServiceStarted)
        if (EndlessService.isServiceStarted) actionOnService(Actions.START)
    }

    fun sendMSGWhatsapp(text: String) {
        val pm = packageManager
        try {
            val waIntent = Intent(Intent.ACTION_SEND)
            waIntent.type = "text/plain"
            val info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA)
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp")
            waIntent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(waIntent, "Share with"))
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun setupUI() {
        binding.tvTitle.text = getString(R.string.app_name)
        binding.tvAlert.setOnClickListener {
            PrintingUtils.showDialog(this@MainActivity, object : SingleActionListener {
                override fun onClick(msg: String) {
                    sendMSGWhatsapp(msg)
                }

            })
        }

        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView?.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(ArrayList(), this@MainActivity)
        binding.recyclerView?.adapter = adapter

        binding.requestNotifAccess.setOnClickListener {
            requestNotifAccess()
        }

        binding.btnStartService.setOnClickListener {
            startServiceAction()
        }

        binding.btnStopService.setOnClickListener {
            log("STOP THE printing SERVICE ON DEMAND")
            actionOnService(Actions.STOP)
            viewModel.markAllASPrint()
            checkService(false)
        }

        binding.tvCnt.setOnClickListener {
            markASPrint()
        }

        binding.btPrint.setOnClickListener {
            runBlocking {
                binding.btPrint.text = "Printing"
                var x = adapter.getList()
                x.filter { it.IsChecked }.forEach {
                    delay(1500)
                    onLongItemClick(it)
                }.run {
                    binding.btPrint.text = "Print"
                    adapter.resetSelection()
                }

            }
        }

        binding.btReset.setOnClickListener {
            adapter.resetSelection()
        }

        binding.btselectAll.setOnClickListener {
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
            binding.tvCnt.text = "Today Items : " + pic.filter {
                viewModel.getDate(it.time).let { d ->
                    d.year == today.year && d.month == today.month && d.day == today.day
                }
            }.size + "   Pending Items : " + pic.count { !it.isPrinted }

            adapter.getList().filter { it.IsChecked }.forEach { x ->
                pic.find { it.filePath == x.filePath && it.fileName == x.fileName && it.msg == x.msg }?.IsChecked =
                    x.IsChecked
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
            binding.btReset.isEnabled = true
            binding.btPrint.isEnabled = true
        } else {
            binding.btReset.isEnabled = false
            binding.btPrint.isEnabled = false
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
            Toast.makeText(
                this@MainActivity,
                getString(R.string.request_notif_access),
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(SETTINGS_NOTIF_LISTENER))
        }
    }


    private fun checkService(flag: Boolean) {
        // btnSetupPrinter.visibility = View.GONE

        if (flag) {
            binding.btnStartService.visibility = View.GONE
            binding.btnStopService.visibility = View.VISIBLE
        } else {
            binding.btnStartService.visibility = View.VISIBLE
            binding.btnStopService.visibility = View.GONE
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
        runOnUiThread {
            binding.requestNotifAccess.visibility = if (isAccessEnabled) View.GONE else View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {

        }
    }

    private fun requestManageStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Request MANAGE_EXTERNAL_STORAGE permission for Android 11 and above
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            try {
                startActivityForResult(intent, 101)
            } catch (e: ActivityNotFoundException) {
                toast("Cannot open settings screen. Please enable storage access manually in settings.")
            }
        } else {
            // No need to request permission for Android versions below 11
            toast("Manage External Storage permission is not required for this Android version")
        }
    }

    private fun startServiceAction() {
        updateCount()
        // Check Android version and handle permissions accordingly
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val hasManageStoragePermission = Environment.isExternalStorageManager()
            if (!hasManageStoragePermission) {
                requestManageStoragePermission()
            } else {
                log("START THE FOREGROUND SERVICE ON DEMAND")
                actionOnService(Actions.START)
                val launchIntent = packageManager.getLaunchIntentForPackage("com.guibais.whatsauto")
                launchIntent?.let { startActivity(it) }
                updateCount()
            }
        } else {
            // For Android versions below 11, check for READ_EXTERNAL_STORAGE
            Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        log("START THE FOREGROUND SERVICE ON DEMAND")
                        actionOnService(Actions.START)
                        val launchIntent =
                            packageManager.getLaunchIntentForPackage("com.guibais.whatsauto")
                        launchIntent?.let { startActivity(it) }
                        updateCount()
                    }

                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        toast("Please allow all permission")
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: PermissionRequest?,
                        token: PermissionToken?
                    ) {
                        token?.continuePermissionRequest()
                    }
                })
                .withErrorListener {
                    toast(it.name)
                }
                .check()
        }
    }


    private fun markASPrint() {
        val dialogClickListener = DialogInterface.OnClickListener { dialog, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {
                    // Check Android version and handle permissions accordingly
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        val hasManageStoragePermission = Environment.isExternalStorageManager()
                        if (!hasManageStoragePermission) {
                            requestManageStoragePermission()
                        } else {
                            viewModel.markAllASPrint()
                        }
                    } else {
                        Dexter.withContext(this)
                            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            .withListener(object : PermissionListener {
                                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                                    viewModel.markAllASPrint()
                                }

                                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                                    toast("Please allow all permission")
                                }

                                override fun onPermissionRationaleShouldBeShown(
                                    p0: PermissionRequest?,
                                    token: PermissionToken?
                                ) {
                                    token?.continuePermissionRequest()
                                }
                            })
                            .withErrorListener {
                                toast(it.name)
                            }
                            .check()

                        dialog.dismiss()
                    }
                }

                DialogInterface.BUTTON_NEGATIVE -> {
                    dialog.dismiss()
                }
            }
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mark all photos are printed").setMessage("Are you sure?")
            .setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener).show()
    }

    fun updateCount() {
        binding.btnStartService.text =
            "Start Printing Service  #${SessionManager.getPrintCount()} ==  #${SessionManager.getPrintCountT()}"
        binding.btnStopService.text =
            "Stop Printing Service  #${SessionManager.getPrintCount()}  == #${SessionManager.getPrintCountT()}"
    }
}
