package com.example.a5102kotlin

import java.util.*
import kotlin.collections.ArrayList

class Main{

    var photo: ArrayList<Photo>? =null
    var story: LinkedList<Story> = LinkedList()


    constructor(story: LinkedList<Story>) {
        this.story = story
    }

    constructor(photo: ArrayList<Photo>){
        this.photo = photo
    }
}