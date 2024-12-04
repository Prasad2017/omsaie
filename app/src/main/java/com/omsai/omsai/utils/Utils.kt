package com.omsai.omsai.utils

import android.util.Log
import android.widget.Toast
import com.omsai.omsai.App

fun log(msg: String) {
    Log.d("ENDLESS-SERVICE", msg)
}

fun log(tag: String, msg: String) {
    Log.d(tag, msg)
}

fun toast(msg: String) {
    try {
        Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
    }
    Log.wtf("wtf", msg)
}
