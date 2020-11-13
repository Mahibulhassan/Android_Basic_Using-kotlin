package com.mahibul.studentapp.netword

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {

    private const val BASE_URL = "https://test.hellohasan.com/android-course-api/"
    private  val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getClient(): Retrofit {
        return retrofit
    }


}