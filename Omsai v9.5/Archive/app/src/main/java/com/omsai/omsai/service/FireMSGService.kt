package com.omsai.omsai.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.omsai.omsai.utils.SessionManager

class FireMSGService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // startNotification
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        SessionManager.setToken(token)
        Log.i("FireMSGService", "onTokenRefresh completed with token: $token")
    }

}
