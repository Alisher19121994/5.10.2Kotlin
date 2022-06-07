package com.example.a5102kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }

    private fun initviews() {
        recyclerView = findViewById(R.id.main_recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        getAdapter(data())
    }

    private fun data(): ArrayList<Main> {
        val list = ArrayList<Main>()
        val photo = ArrayList<Photo>()
        val story = LinkedList<Story>()

        list.add(Main(story))
        for (i in 0..30) {
            story.add(Story(R.drawable.ali, "Alisher"))
        }
        for (i in 0..4) {
            photo.add(Photo(R.drawable.rasms))
        }

        for (i in 0..30) {
            list.add(Main(photo))
        }

        return list
    }

    private fun getAdapter(data: ArrayList<Main>) {
        val adapter = PostsAdapter(this, data)
        recyclerView.adapter = adapter
    }

}