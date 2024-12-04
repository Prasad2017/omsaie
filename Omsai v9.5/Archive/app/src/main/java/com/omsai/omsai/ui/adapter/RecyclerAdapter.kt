package com.omsai.omsai.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.omsai.omsai.App
import com.omsai.omsai.R
import com.omsai.omsai.db.Photo
import com.squareup.picasso.Picasso
import java.io.File

class RecyclerAdapter(var photos: List<Photo>, private val listener: ClickListener) : RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder = PhotoHolder(parent.inflate(R.layout.list_item, false))

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
        val f = File(photo.filePath)
        if (photo.isPhoto) {
            holder.tvMsg?.text = "Photo"

            Picasso.get().load(f).into(holder.image)
            holder.image?.setOnClickListener {
                listener.onItemClick(photo)
            }
        } else {
            holder.tvMsg?.text = photo.msg

            Picasso.get().load(R.drawable.logoauto).into(holder.image)
            holder.image?.setOnClickListener {
                listener.onItemClick(photo)
            }
        }
        holder.date?.text = photo.humanDate()
      //  holder.name?.visibility = if (photo.isPhoto) View.GONE else View.VISIBLE
        holder.name?.text = photo.fileName

        holder.card?.setCardBackgroundColor(if (photo.isPrinted) App.colorDone!! else App.colorPending!!);

        holder.tvCnt?.text = "#${photo.count.toString()}"
        holder.itemView.setOnClickListener {
            holder.checkbox?.performClick()
        }

        holder.itemView.setOnLongClickListener {
            listener.onLongItemClick(photo)
            true
        }

        holder.checkbox?.setOnClickListener {

            if (holder.checkbox?.isChecked == true) {
                photos[position].IsChecked = true
                listener.onCheckAction(photos)

            } else {
                photos[position].IsChecked = false
                listener.onCheckAction(photos)
            }
        }

        holder.checkbox?.isChecked = photo.IsChecked

    }

    fun resetSelection() {
        photos.map { it.IsChecked = false }
        photos = photos
        listener.onCheckAction(photos)
        notifyDataSetChanged()
    }

    fun selectAll() {
        photos.map { it.IsChecked = true }
        photos = photos
        listener.onCheckAction(photos)
        notifyDataSetChanged()
    }

    fun setData(photos1: List<Photo>) {
        photos = photos1
        notifyDataSetChanged()
    }

    fun getList(): List<Photo> = photos

    override fun getItemCount(): Int = photos.size

    class PhotoHolder(v: View) : RecyclerView.ViewHolder(v) {
        var image: ozaydin.serkan.com.image_zoom_view.ImageViewZoom? = v.findViewById(R.id.ivImage)
        var name: TextView? = v.findViewById(R.id.tvFile)
        var date: TextView? = v.findViewById(R.id.tvDate)
        var tvMsg: TextView? = v.findViewById(R.id.tvMsg)
        var card: CardView? = v.findViewById(R.id.card)
        var tvCnt: TextView? = v.findViewById(R.id.tvCnt)
        var checkbox: CheckBox? = v.findViewById(R.id.checkBox)

    }

    interface ClickListener {
        fun onCheckAction(photos: List<Photo>)
        fun onLongItemClick(photo: Photo)
        fun onItemClick(photo: Photo)
    }


}