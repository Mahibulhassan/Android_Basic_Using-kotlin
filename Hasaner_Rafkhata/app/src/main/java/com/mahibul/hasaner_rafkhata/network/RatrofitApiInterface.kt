package com.mahibul.hasaner_rafkhata.network

import com.mahibul.hasaner_rafkhata.home.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface RatrofitApiInterface {

   @GET("posts")
   fun getallPosts() : Call<MutableList<Post>>
}