package com.mahibul.hasaner_rafkhata.home.model

interface NetworkCallBack {

    fun onsuccessonedata (post : Post)
    fun onSuccess (postlist : MutableList<Post>)
    fun onError (throwable: Throwable)
}