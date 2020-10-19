package com.example.retrofic_get_data.network

import com.example.retrofic_get_data.featcher.data_model.Food
import retrofit2.Call
import retrofit2.http.GET


interface FoodApiInterface {

    @GET("hasancse91/android-course-v2/master/07_Retrofit_GET_Request/data/food.json")
    fun getFoodDetails(): Call<Food>

}