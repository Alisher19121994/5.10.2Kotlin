package com.example.a5102kotlin

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.util.*
import kotlin.collections.ArrayList

class PhotoAdapter(var context: Context, var list: ArrayList<Photo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val photo = list[position]

        if (holder is PhotoViewHolder) {
            holder.pro.setImageResource(photo.photo)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PhotoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val pro: ImageView = item.findViewById(R.id.photo_id)
    }
}