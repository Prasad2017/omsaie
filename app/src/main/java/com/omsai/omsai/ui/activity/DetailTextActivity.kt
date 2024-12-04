package com.omsai.omsai.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.omsai.omsai.databinding.ActivityDetailTextBinding
import com.omsai.omsai.db.Photo
import com.squareup.picasso.Picasso
import java.io.File

const val TEXT_NAME = "name"
const val TEXT_MSG = "msg"
const val TEXT_IMG = "img"

class DetailTextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTextBinding.inflate(layoutInflater)
        val view: View =
            binding.getRoot() //Root xml or viewGroup will be a part of converted view over here
        setContentView(view)
        if (intent.hasExtra(TEXT_NAME)) supportActionBar?.setTitle(intent.getStringExtra(TEXT_NAME))
        if (intent.hasExtra(TEXT_MSG)) {
            binding.msg.text = intent.getStringExtra(TEXT_MSG)
        } else {
            val f = File(intent.getStringExtra(TEXT_IMG))
            Picasso.get().load(f).into(binding.img)
        }
    }

    companion object {
        fun getIntent(context: Context, photo: Photo): Intent =
            if (photo.msg.isEmpty())
                Intent(context, DetailTextActivity::class.java).putExtra(TEXT_NAME, photo.fileName)
                    .putExtra(TEXT_IMG, photo.filePath)
            else
                Intent(context, DetailTextActivity::class.java).putExtra(TEXT_NAME, photo.fileName)
                    .putExtra(TEXT_MSG, photo.msg)
    }
}