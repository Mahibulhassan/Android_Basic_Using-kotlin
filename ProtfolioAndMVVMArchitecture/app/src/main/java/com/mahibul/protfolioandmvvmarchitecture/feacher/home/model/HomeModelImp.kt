package com.mahibul.protfolioandmvvmarchitecture.feacher.home.model

import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitApi
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeModelImp : HomeModel{
    private val apiInterface = RetrofitClint.clint?.create(RetrofitApi::class.java)
    private val call = apiInterface?.getUserDetails()


    override fun getUserDetails(callBack: NetworkCallBack<UserDetails>) {
        call?.clone()?.enqueue(object : Callback<UserDetails> {
            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                response.body().let {
                    if (it != null) {
                        callBack.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                callBack.onError(t)
            }
        })
    }
}