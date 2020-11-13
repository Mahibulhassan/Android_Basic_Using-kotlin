package com.mahibul.studentapp.netword

import com.mahibul.studentapp.home.model.Course_Information
import com.mahibul.studentapp.login.model.LoginResponse
import com.mahibul.studentapp.login.model.StudentResponse
import com.mahibul.studentapp.login.model.UserCredential
import retrofit2.Call
import retrofit2.http.*

interface RetrofitClintApi {

    @GET("course_info.php")
    fun getCourseDetails() : Call<Course_Information>

    @POST("login.php")
    fun logIn(@Body userCredential: UserCredential,@Header("api_key")apikey : String) : Call<LoginResponse>

    @GET ("student.php")
    fun studentList(@Header("api_key") apikey: String, @Header("token") token: String) : Call<StudentResponse>

    @GET("student.php")
    fun studentDetails(@Header("api_key") apikey: String, @Header("token") token: String, @Query("id") Id: Int) : Call<StudentResponse>
}