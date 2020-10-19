package com.example.retrofic_get_data.featcher.data_model

import com.example.retrofic_get_data.network.FoodApiInterface
import com.example.retrofic_get_data.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodModelImp : FoodModel {

    private val apiInterface = RetrofitClint.clint?.create(FoodApiInterface::class.java)
    private val call = apiInterface?.getFoodDetails()


    override fun getFoodDetails(foodCallback: FoodCallback) {

        if (call != null) {
            call.enqueue(object : Callback<Food>{

                override fun onResponse(call: Call<Food>, response: Response<Food>) {
                    response.body()?.let {
                        foodCallback.onSuccess(it)
                    }
                }

                override fun onFailure(call: Call<Food>, t: Throwable) {
                    foodCallback.onError(t)
                }

            })
        }

    }

}