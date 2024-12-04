package com.omsai.omsai.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omsai.omsai.R
import com.omsai.omsai.db.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_text.*
import java.io.File

const val TEXT_NAME = "name"
const val TEXT_MSG = "msg"
const val TEXT_IMG = "img"

class DetailTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_text)
        if (intent.hasExtra(TEXT_NAME)) supportActionBar?.setTitle(intent.getStringExtra(TEXT_NAME))
        if (intent.hasExtra(TEXT_MSG)){
            msg.text = intent.getStringExtra(TEXT_MSG)
        } else {
            val f = File(intent.getStringExtra(TEXT_IMG))
            Picasso.get().load( f).into(img)
        }
    }

    companion object {
        fun getIntent(context: Context, photo: Photo): Intent =
                if (photo.msg.isEmpty())
                    Intent(context, DetailTextActivity::class.java).putExtra(TEXT_NAME, photo.fileName).putExtra(TEXT_IMG, photo.filePath)
                else
                    Intent(context, DetailTextActivity::class.java).putExtra(TEXT_NAME, photo.fileName).putExtra(TEXT_MSG, photo.msg)
    }
}