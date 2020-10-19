package com.example.retrofic_get_data.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClint {
    //This is our base url
    private const val BASE_URL = "https://raw.githubusercontent.com/"
    private var ratrofit : Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    @get: Synchronized
    val clint: Retrofit?
    get(){
        if(ratrofit==null){
            ratrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
        return ratrofit
    }

}