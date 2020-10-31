package com.mahibul.hasaner_rafkhata.home.model

interface PostModel {
    fun postlistdetails (callback : NetworkCallBack)

    fun post(post_id : Int,callback: NetworkCallBack)
}