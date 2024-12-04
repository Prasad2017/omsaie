package com.omsai.omsai.utils

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.omsai.omsai.App

class SessionManager {

    companion object {

        const val SIZE_A4 = "a4"
        const val SIZE_4x6 = "4x6"

        private const val KEY_TOKEN = "TOKEN"
        private const val KEY_USER_NAME = "user"
        private const val KEY_USER_ID = "userID"
        private const val KEY_KEY = "key"
        private const val KEY_IS_LOGOUT = "ISLOGOUT"
        private const val KEY_SIZE = "size"
        private const val KEY_COUNT = "count"
        private const val KEY_COUNT_T = "count_T"
        val PREF_NAME = "mobiledev_auto_print"
        var pref: SharedPreferences
        var editor: Editor

        init {
            pref = App.getContext()!!.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
            editor = pref.edit()
        }

        fun getToken(): String = pref.getString(KEY_TOKEN, "")!!
        fun setToken(UUID: String?) = editor.putString(KEY_TOKEN, UUID).apply()

        fun getUserName(): String = pref.getString(KEY_USER_NAME, "")!!
        fun setUserName(name: String?) = editor.putString(KEY_USER_NAME, name).apply()

        fun getUserID(): String = pref.getString(KEY_USER_ID, "")!!
        fun setUserID(id: String?) = editor.putString(KEY_USER_ID, id).apply()

        fun getKey(): String = pref.getString(KEY_KEY, "")!!
        fun setKey(id: String?) = editor.putString(KEY_KEY, id).apply()

        fun getPrintCount(): Long = pref.getLong(KEY_COUNT, 0)
        fun setPrintCount(id: Long) = editor.putLong(KEY_COUNT, id).commit()
        fun setPrintCountAdd() = try {
            editor.putLong(KEY_COUNT, getPrintCount() + 1).commit()
        } catch (e: java.util.UnknownFormatConversionException) {
            e.printStackTrace()
        }

        fun getPrintCountT(): Long = pref.getLong(KEY_COUNT_T, 0)
        fun setPrintCountT(cnt: Long) = editor.putLong(KEY_COUNT_T, cnt).commit()
        fun setPrintCountAddT() = try {
            editor.putLong(KEY_COUNT_T, getPrintCountT() + 1).commit()
        } catch (e: java.util.UnknownFormatConversionException) {
            e.printStackTrace()
        }
    }

}