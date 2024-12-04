package com.omsai.omsai.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.text.SimpleDateFormat
import java.util.Date


@Entity(tableName = "Photo", primaryKeys = ["filepath", "filename", "msg", "last_row_id"])
class Photo {
    constructor(
        fileName: String?,
        filePath: String,
        isPrinted: Boolean = false,
        time: Long = 0L,
        isPhoto: Boolean = true,
        msg: String = "",
        last_row_id: String = "",
        count: Long
    ) {
        this.fileName = fileName ?: ""
        this.filePath = filePath
        this.last_row_id = last_row_id
        this.isPrinted = isPrinted
        this.time = time
        this.msg = msg
        this.isPhoto = isPhoto
        this.count = count
    }

    @ColumnInfo(name = "filename")
    var fileName: String = ""

    @ColumnInfo(name = "msg")
    var msg: String = ""

    @ColumnInfo(name = "filepath")
    var filePath: String = ""

    @ColumnInfo(name = "last_row_id")
    var last_row_id: String = ""

    @ColumnInfo(name = "isprinted")
    var isPrinted: Boolean = false

    @ColumnInfo(name = "isPhoto")
    var isPhoto: Boolean = true

    @ColumnInfo(name = "time")
    var time: Long = 0L

    @ColumnInfo(name = "count")
    var count: Long = 0L

    var IsChecked: Boolean = false

    fun humanDate(): String {
        return SimpleDateFormat("dd-MM-yyyy hh:mm a").format(Date(time))
    }

}