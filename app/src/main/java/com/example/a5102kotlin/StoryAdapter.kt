package com.example.a5102kotlin

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var list:List<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = list[position]

        if (holder is StoryViewHolder) {
            holder.fullname.text = story.fullname
            holder.pro.setImageResource(story.profile)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class StoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val pro: ShapeableImageView = item.findViewById(R.id.story_profile_id)
        val fullname: TextView = item.findViewById(R.id.story_fullname_id)
    }
}