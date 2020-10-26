package com.example.mvparchitecture.home.model

import com.example.mvparchitecture.network.RetrofitApiInterface
import com.example.mvparchitecture.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitModelimp : FruitModel {

    private val apinterface = RetrofitClint.getClient().create(RetrofitApiInterface::class.java)
    private val call = apinterface.getfruitdetails()

    override fun details(foodcallback: FruitCallBack) {
        call.enqueue(object : Callback<MutableList<Fruit_model>>{
            override fun onResponse(call: Call<MutableList<Fruit_model>>, response: Response<MutableList<Fruit_model>>) {
                response.body()?.let {
                        foodcallback.onsuccessgetdat(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Fruit_model>>, t: Throwable) {
                foodcallback.onerrorgetdata(t)
            }

        })

    }
}