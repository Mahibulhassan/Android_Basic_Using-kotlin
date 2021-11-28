package com.mahibul.dcc_18.network

import com.mahibul.dcc_18.Model.DataClass
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("categories")
    fun getData () : Call<DataClass>
}