package com.omsai.omsai

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.graphics.Color
import android.os.PowerManager
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.omsai.omsai.db.Photo
import com.omsai.omsai.db.PhotoDao
import com.omsai.omsai.db.PhotoDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class App : Application() {


    @SuppressLint("InvalidWakeLockTag")
    override fun onCreate() {
        super.onCreate()
        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        ctx = this
        db = PhotoDatabase.getDB(this)
        GlobalScope.launch {
            daoPhoto = getDatabase()?.daoPhoto()
            photo = daoPhoto?.loadPhotoForPrint()
        }
        GlobalScope.launch {
            daoPhoto = getDatabase()?.daoPhoto()
            var r = daoPhoto?.load()
            r?.map { it.IsChecked = false }
            if (r != null) daoPhoto?.insertAll(r)
        }
        p = getSystemService(Context.POWER_SERVICE) as PowerManager
        wake = p?.newWakeLock(PowerManager.FULL_WAKE_LOCK, "don't dim my screen")

         colorPending = Color.parseColor("#FFE8C963")
         colorDone = Color.parseColor("#FF99ED96")
    }

    companion object {
        fun isActiveMode(): Boolean = p?.isScreenOn ?: true && p?.isInteractive ?: true

        var p: PowerManager? = null
        var wake: PowerManager.WakeLock? = null
        var ctx: Context? = null
        var colorPending: Int?=null
        var colorDone: Int?=null
        var db: PhotoDatabase? = null
        var isValidKey = false
        var daoPhoto: PhotoDao? = null
        var photo: Photo? = null
        fun getContext(): Context? = ctx
        fun getDatabase(): PhotoDatabase? = db

    }
}