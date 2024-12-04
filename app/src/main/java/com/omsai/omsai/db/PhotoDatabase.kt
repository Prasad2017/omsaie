package com.omsai.omsai.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 3, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun daoPhoto(): PhotoDao?

    companion object {
        var db: PhotoDatabase? = null
        fun getDB(context: Context): PhotoDatabase {
            if (db == null) {
                try {
                    db = Room.databaseBuilder(context, PhotoDatabase::class.java, "WPDatabase")
                        .setJournalMode(JournalMode.TRUNCATE)
                        .build()
                } catch (e: Exception) {
                    Log.e("WPDatabase", e.fillInStackTrace().toString())
                }
            }
            return db as PhotoDatabase
        }
    }
}