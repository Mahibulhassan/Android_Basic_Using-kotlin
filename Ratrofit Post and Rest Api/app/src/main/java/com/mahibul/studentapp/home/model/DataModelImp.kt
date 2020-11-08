package com.mahibul.studentapp.home.model

import com.mahibul.studentapp.netword.RetrofitClint
import com.mahibul.studentapp.netword.RetrofitClintApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataModelImp : DataModel {

    private val apinterface =RetrofitClint.getClient().create(RetrofitClintApi::class.java)

    override fun courseInformation(callback: NetworkCallback) {
        val call = apinterface.getCourseDetails()
        call.enqueue(object : Callback<Course_Information>{
            override fun onResponse(call: Call<Course_Information>, response: Response<Course_Information>) {
                response.body()?.let {
                    callback.courseInformation(it)
                }
            }

            override fun onFailure(call: Call<Course_Information>, t: Throwable) {
                callback.networkError(t)
            }
        })

    }
}