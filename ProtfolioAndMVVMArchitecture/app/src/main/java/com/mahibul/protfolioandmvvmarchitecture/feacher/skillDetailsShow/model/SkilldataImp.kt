package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model


import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitApi
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkilldataImp : SkillDataModel {
    private val apiInterface = RetrofitClint.clint?.create(RetrofitApi::class.java)
    private val call = apiInterface?.getListDetais()
    override fun getSkillDetails(callback: NetworkCallBack<ListSkillData>) {
        call?.enqueue(object : Callback<ListSkillData>{
            override fun onResponse(call: Call<ListSkillData>, response: Response<ListSkillData>) {
                response.body().let{
                    if (it != null) {
                        callback.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<ListSkillData>, t: Throwable) {
                callback.onError(t)
            }

        })
    }
}