package com.example.fruitpanda.network

import com.example.fruitpanda.fruit_model.Fruit_model
import retrofit2.Call
import retrofit2.http.GET

interface FruitApiInterface {

    @GET("hasancse91/android-course-v2/master/08_Recap_RecyclerView_Retrofit/data/foodlist.json")
    fun getFruitdetails() : Call<MutableList<Fruit_model>>
}