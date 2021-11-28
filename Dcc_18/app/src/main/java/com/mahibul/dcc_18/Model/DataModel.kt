package com.mahibul.dcc_18.Model

import com.mahibul.dcc_18.network.ApiInterface
import com.mahibul.dcc_18.network.RetrofitClint
import retrofit2.Call
import retrofit2.Response


class DataModel {

    private val apiinterface = RetrofitClint.getClient()?.create(ApiInterface::class.java)
    private val call = apiinterface.getData()
    fun getData (dataCallback: DataCallback){

        if(call!= null){
           call.enqueue(object : retrofit2.Callback<DataClass>{
               override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                   response.body()?.let {
                       dataCallback.onSuccess(it)
                   }
               }

               override fun onFailure(call: Call<DataClass>, t: Throwable) {
                   dataCallback.onError(t)
               }
           })
        }
    }

}