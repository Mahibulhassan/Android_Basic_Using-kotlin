package com.mahibul.hasaner_rafkhata.home.view

import com.mahibul.hasaner_rafkhata.home.model.Post

interface PostView {
    fun showlist(postlist : MutableList<Post>)
    fun showonepost(post : Post)
    fun showerror(msg: String)
}