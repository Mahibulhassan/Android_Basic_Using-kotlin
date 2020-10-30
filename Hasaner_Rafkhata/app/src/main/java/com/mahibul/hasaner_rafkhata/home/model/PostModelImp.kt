package com.mahibul.hasaner_rafkhata.home.model

import com.mahibul.hasaner_rafkhata.network.RatrofitApiInterface
import com.mahibul.hasaner_rafkhata.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostModelImp : PostModel {
    private val apinterface = RetrofitClint.getClient().create(RatrofitApiInterface::class.java)
    private val callallpost = apinterface.getallPosts()

    override fun postlistdetails(callback: NetworkCallBack) {
        callallpost.enqueue(object : Callback<MutableList<Post>>{
            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                callback.onError(t)
            }

        })

    }
}