package com.mahibul.dcc_18.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {


    private const val BASE_URL = "https://dev.6amtech.com/efood/api/v1/" //address of your remote server

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    fun getClient(): Retrofit {
        return retrofit
    }
}