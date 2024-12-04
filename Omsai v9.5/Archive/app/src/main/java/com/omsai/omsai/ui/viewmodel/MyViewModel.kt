package com.omsai.omsai.ui.viewmodel

import android.annotation.SuppressLint
import android.os.Environment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.omsai.omsai.App
import com.omsai.omsai.db.Photo
import com.omsai.omsai.service.toast
import com.omsai.omsai.utils.PrintingUtils
import com.omsai.omsai.utils.SessionManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MyViewModel : ViewModel() {


    fun getUsers(): LiveData<List<Photo>>? {
        val dao = App.getDatabase()?.daoPhoto()
        return dao?.getAllPhotos()?.asLiveData()
    }

    @SuppressLint("SimpleDateFormat")
    fun getDate(time: Long): Date {
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a")
        sdf.timeZone = Calendar.getInstance().timeZone//get your local time zone.
        var dateq = Date()
        try {
            dateq = sdf.parse(sdf.format(Date(time)))//get local date
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return dateq
    }

    fun markAllASPrint() = GlobalScope.launch {
        val folder = File(Environment.getExternalStorageDirectory().toString() + "/WhatsApp/Media/WhatsApp Images/")
        if (folder.exists()) {
            val allFiles: Array<File> = folder.listFiles { _, name -> name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") }
            SessionManager.setPrintCountAdd()
            var count = SessionManager.getPrintCount()

            App.getDatabase()?.daoPhoto()?.insertAll(allFiles.map { Photo(it.name, it.absolutePath, true, Date(it.lastModified()).time,true,"","",count) })

            App.daoPhoto = App.getDatabase()?.daoPhoto()
            val r = App.daoPhoto?.load()
            r?.map { it.isPrinted = true }
            if (r != null) App.daoPhoto?.insertAll(r)

        } else {
            toast("Files not able scan")
        }
        SessionManager.setPrintCount(0)
        SessionManager.setPrintCountT(0)
    }

    fun print(photo: Photo, job: PrintingUtils.PrintJob) {
        if (photo.isPhoto)
            PrintingUtils.printPhoto2(photo, job)
        else
            try {
                PrintingUtils.printText(photo, job)
            } catch (e: java.util.UnknownFormatConversionException) {
                photo.isPrinted = true
                App.getDatabase()?.daoPhoto()?.insert(photo)
            }
    }

}