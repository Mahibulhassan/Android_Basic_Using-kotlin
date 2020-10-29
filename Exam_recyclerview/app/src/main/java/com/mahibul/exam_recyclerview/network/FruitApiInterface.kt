package com.example.fruitpanda.network

import com.mahibul.myapplication.home.model.Fruit
import retrofit2.Call
import retrofit2.http.GET

interface FruitApiInterface {

    @GET("Mahibulhassan/Project_data-Json-data/main/Data_Fruit.json")
    fun getFruitdetails() : Call<MutableList<Fruit>>
}