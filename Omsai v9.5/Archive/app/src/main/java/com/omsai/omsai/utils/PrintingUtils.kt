package com.omsai.omsai.utils

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.StrictMode
import com.omsai.omsai.App
import com.omsai.omsai.db.Photo
import com.omsai.omsai.service.toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.lang.String
import java.util.*


object PrintingUtils {
    fun scanFiles() = GlobalScope.launch {
        val folder = File(Environment.getExternalStorageDirectory().toString() + "/WhatsApp/Media/WhatsApp Images/")
        if (folder.exists()) {
            val allFiles: Array<File> = folder.listFiles { dir, name -> name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") }
            val database = App.getDatabase()
            val mainDBList = database?.daoPhoto()?.load()
            val x = allFiles.filter { f -> mainDBList?.find { f.name == it.fileName } == null }

            if (x.isNotEmpty()) database?.daoPhoto()?.insertAll(x.map {
                SessionManager.setPrintCountAdd()
                val count = SessionManager.getPrintCount()

                Photo(it.name, it.absolutePath, false, Date(it.lastModified()).time, true, "","", count)
            })
        } else {
            toast("Files not able scan")
        }
    }

    fun printPhoto2(photo: Photo, listener: PrintJob) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode::class.java.getMethod("disableDeathOnFileUriExposure").invoke(null)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        val uri = Uri.parse("file://" + photo.filePath)
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "text/plain"
        sendToPrint(intent, listener)
    }

    fun printText(photo: Photo, listener: PrintJob) {
        if (App.isActiveMode()) {
            val textToPrint = String.format(Locale.ROOT, photo.msg, 4)

            val sb = StringBuilder()
            sb.append("#${photo.count}\n")
            sb.append("${photo.fileName}\n \n")
            sb.append(textToPrint)

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, sb as CharSequence)
            sendToPrint(intent, listener)
        }
    }

    /**
     * Checks and if the application is not installed, then offers to download it from the Play Market
     */
    fun sendToPrint(intent: Intent, listener: PrintJob) {
        val appPackageName = "ru.a402d.rawbtprinter"
        val pm: PackageManager = App.getContext()!!.getPackageManager()

        // check app installed
        var pi: PackageInfo? = null
        if (pm != null) {
            try {
                pi = pm.getPackageInfo(appPackageName, 0)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }
        if (pi != null) {
            // send to print
            intent.setPackage(appPackageName)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            App.getContext()?.startActivity(intent)
            listener.OnSuccessful()
        } else {
            listener.OnFail()
        }
    }

    /**
     * add in manifest :
     * <uses-permission android:name="ru.a402d.rawbtprinter.PERMISSION"></uses-permission>
     */
    /*fun test15(filePath: kotlin.String) {

        val bmp = Bitmap.createBitmap(canvasPage.getWidth(), canvasPage.getHeight(), Bitmap.Config.ARGB_8888)

        // draw border for example in printable

        // draw border for example in printable
        val canvasBmp = Canvas(bmp)

        val paint = Paint()
        paint.setColor(Color.BLACK)
        canvasBmp.drawRect(0f, 0f, canvasBmp.getWidth().toFloat(), canvasBmp.getHeight().toFloat(), paint)

        paint.setColor(Color.WHITE)
        val borderWidth = 3f
        canvasBmp.drawRect(borderWidth, borderWidth,
                canvasBmp.getWidth() - borderWidth,
                canvasBmp.getHeight() - borderWidth,
                paint)

        paint.setColor(Color.BLACK)
        paint.setTextSize(24f)
        canvasBmp.drawText("Hello, BMP!", 54f, 50f, paint)

        canvasPage.drawBitmap(bmp, 0f, 0f, null)

        // direct on page

        val bitmap = BitmapFactory.decodeFile(filePath)

        // direct on page
        paint.setColor(Color.BLACK)
        paint.setTextSize(24f)
        canvasPage.drawBitmap(bitmap, 0f, 10f, paint)
        canvasPage.drawText("Hello, PAGE!", 54f, 100f, paint)

        var file = File(App.getContext()!!.getCacheDir(), "temporary_file.jpg")
        val os: OutputStream = BufferedOutputStream(FileOutputStream(file))
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
        os.close()

        val uri = Uri.parse("file://" + file.absoluteFile)
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "text/plain"
        sendToPrint(intent, listener)

    }*/


    interface PrintJob {
        fun OnSuccessful()
        fun OnFail()
    }
}