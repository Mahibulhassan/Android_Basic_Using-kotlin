package com.example.fruitpanda.fruit_model

import com.mahibul.myapplication.home.model.Fruit
import com.example.fruitpanda.network.FruitApiInterface
import com.example.fruitpanda.network.RetrofitClint
import com.mahibul.fruitpanda.fruit_model.FruitlistModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FruitModelImp : FruitlistModel {

    private val apiInterface = RetrofitClint.getClient().create(FruitApiInterface::class.java)
    private val call = apiInterface.getFruitdetails()

    override fun getFoodlist(fruitlistCallback: FruitlistCallback) {
        call.enqueue(object : Callback<MutableList<Fruit>>{

            override fun onResponse(call: Call<MutableList<Fruit>>, response: Response<MutableList<Fruit>>) {
            response.body()?.let {
                    fruitlistCallback.onSuccess(it)
                 }
                         }

            override fun onFailure(call: Call<MutableList<Fruit>>, t: Throwable) {
                fruitlistCallback.onError(t)
            }

        })

    }
}

