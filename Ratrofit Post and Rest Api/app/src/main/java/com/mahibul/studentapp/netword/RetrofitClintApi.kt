package com.mahibul.studentapp.netword

import com.mahibul.studentapp.home.model.Course_Information
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitClintApi {

    @GET("/course_info.php")
    fun getCourseDetails() : Call<Course_Information>
}