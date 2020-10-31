package com.mahibul.hasaner_rafkhata.network

import com.mahibul.hasaner_rafkhata.home.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RatrofitApiInterface {

   @GET("posts")
   fun getallPosts() : Call<MutableList<Post>>

   @GET("posts/{post_id}")
   fun getpost(@Path("post_id")post_id : Int) : Call<Post>
}