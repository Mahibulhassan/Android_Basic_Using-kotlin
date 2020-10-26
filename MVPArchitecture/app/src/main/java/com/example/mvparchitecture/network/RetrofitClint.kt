package com.example.mvparchitecture.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {

    private val BAS_URL = "https://raw.githubusercontent.com/"
    private val Gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BAS_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson))
            .build()

    fun getClient(): Retrofit {
        return retrofit
    }
}