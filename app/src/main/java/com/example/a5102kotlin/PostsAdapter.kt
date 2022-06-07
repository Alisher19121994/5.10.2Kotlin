package com.example.a5102kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import java.util.*

import kotlin.collections.ArrayList

class PostsAdapter(var context: Context, var list: ArrayList<Main>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var STORY = 0
    private var POST = 1

      override fun getItemViewType(position: Int): Int {

          return  if (list[position].story.size > 0)  STORY else POST

      }

     private fun storyAdapter(story:List<Story>, recyclerView: RecyclerView) {
          val adapter = StoryAdapter(context, story)
          recyclerView.adapter = adapter
      }

    private fun photoAdapter(photo: ArrayList<Photo>, recyclerView: RecyclerView) {
        val adapter = PhotoAdapter(context, photo)
        recyclerView.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
           if (viewType == STORY) {
               val view = LayoutInflater.from(parent.context).inflate(R.layout.story, parent, false)
               return StoryViewHolder(view)
           }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PhotoViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val main = list[position]


          if (holder is StoryViewHolder) {
              val recyclerView = holder.recyclerView
              storyAdapter(main.story, recyclerView)
          }


        if (holder is PhotoViewHolder) {
            val recyclerView = holder.recyclerView
          //  photoAdapter(main!!.photo, recyclerView)
            main.photo?.let { photoAdapter(it,recyclerView) }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class StoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView: RecyclerView = item.findViewById(R.id.story_recyclerview)

        init {
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    inner class PhotoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView: RecyclerView = item.findViewById(R.id.photo_recyclerView)

        init {
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }
}