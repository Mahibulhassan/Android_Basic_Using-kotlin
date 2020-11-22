package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model

import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitApi
import com.mahibul.protfolioandmvvmarchitecture.network.RetrofitClint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SkillModelImp : SkillModel {
    private val apiInterface = RetrofitClint.clint?.create(RetrofitApi::class.java)
    private val call = apiInterface?.getSkillDetails()

    override fun getSkillDetails(callback: NetworkCallBack<SkillData>) {
        call?.enqueue(object : Callback<SkillData> {
            override fun onResponse(call: Call<SkillData>, response: Response<SkillData>) {
                response.body().let {
                    if (it != null) {
                        callback.onSuccess(it)
                    }
                }
            }
            override fun onFailure(call: Call<SkillData>, t: Throwable) {
                callback.onError(t)
            }
        })
    }
}