package com.example.fruitpanda.network

import com.example.fruitpanda.fruit_model.Fruit_model
import retrofit2.Call
import retrofit2.http.GET

interface FruitApiInterface {

    @GET("Mahibulhassan/Project_data-Json-data/main/Data_Fruit.json")
    fun getFruitdetails() : Call<MutableList<Fruit_model>>
}