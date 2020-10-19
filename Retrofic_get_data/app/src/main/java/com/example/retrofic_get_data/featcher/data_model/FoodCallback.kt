package com.example.retrofic_get_data.featcher.data_model

interface FoodCallback {
    fun onSuccess(food: Food)
    fun onError(errorMessage: Throwable)
}