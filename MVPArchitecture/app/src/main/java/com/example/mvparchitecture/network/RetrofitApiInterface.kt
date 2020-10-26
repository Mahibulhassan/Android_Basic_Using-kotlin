package com.example.mvparchitecture.network

import com.example.mvparchitecture.home.model.Fruit_model
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiInterface {

    @GET("Mahibulhassan/Project_data-Json-data/main/Data_Fruit.json")
    fun getfruitdetails() : Call<MutableList<Fruit_model>>
}