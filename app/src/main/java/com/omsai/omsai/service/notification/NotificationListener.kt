package com.omsai.omsai.service.notification

import android.annotation.SuppressLint
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.omsai.omsai.App
import com.omsai.omsai.db.Photo
import com.omsai.omsai.utils.SessionManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date


@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressLint("OverrideAbstract")
class NotificationListener : NotificationListenerService() {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (sbn.packageName != WA_PACKAGE) return
        val bundle = sbn.notification.extras
        val name = bundle.getString(NotificationCompat.EXTRA_TITLE)
        val message = if (bundle.getString(NotificationCompat.EXTRA_TEXT) != null) bundle.getString(
            NotificationCompat.EXTRA_TEXT
        ) else bundle["android.text"].toString()

        if (bundle["last_row_id"] != null && bundle["android.title"].toString() != "You") {
            var x = bundle["last_row_id"].toString()
            if (message != null && message.isNotEmpty()) addToDB(name, message, x)
        }

    }

    private fun addToDB(name: String?, message: String, last_row_id: String) = GlobalScope.launch {
        if (!(name ?: "").contains("WhatsApp", true)
            && !message.contains("Photo", true)
            && !message.contains("messages", true)
            && !message.contains("ring", true)
            && !message.contains("missed", true)
            && !message.contains("new", true)
            && !message.contains("GIF", true)
            && !message.contains("Video", true)
            && !message.contains("Voice", true)
        ) {

            SessionManager.setPrintCountAddT()
            val count = SessionManager.getPrintCountT()

            App.getDatabase()?.daoPhoto()
                ?.insert(Photo(name, "", false, Date().time, false, message, last_row_id, count))
        }
    }

    override fun onListenerConnected() {
        Log.i(TAG, "Notification Listener connected")
    }

    companion object {
        private const val TAG = "NotificationListener"
        private const val WA_PACKAGE = "com.whatsapp"
    }
}