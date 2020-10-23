package com.example.fruitpanda.fruit_model

import com.example.fruitpanda.network.FruitApiInterface
import com.example.fruitpanda.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FruitModelImp : FruitlistModel {

    private val apiInterface = RetrofitClint.getClient().create(FruitApiInterface::class.java)
    private val call = apiInterface.getFruitdetails()

    override fun getFoodlist(fruitlistCallback: FruitlistCallback) {
        call.enqueue(object : Callback<MutableList<Fruit_model>>{

            override fun onResponse(call: Call<MutableList<Fruit_model>>, response: Response<MutableList<Fruit_model>>) {
            response.body()?.let {
                    fruitlistCallback.onSuccess(it)
                 }
                         }

            override fun onFailure(call: Call<MutableList<Fruit_model>>, t: Throwable) {
                fruitlistCallback.onError(t)
            }

        })

    }
}

