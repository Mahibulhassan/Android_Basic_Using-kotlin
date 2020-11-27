package com.mahibul.protfolioandmvvmarchitecture.network

import com.mahibul.protfolioandmvvmarchitecture.feacher.home.model.UserDetails
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillData
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model.ListSkillData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("Mahibulhassan/Project_data-Json-data/main/cat.json")
    fun getUserDetails(): Call<UserDetails>

    @GET("/Mahibulhassan/Project_data-Json-data/main/skills.json")
    fun getSkillDetails(): Call<SkillData>

    @GET("/Mahibulhassan/Project_data-Json-data/main/skills.json")
    fun getListDetais(): Call<ListSkillData>
}