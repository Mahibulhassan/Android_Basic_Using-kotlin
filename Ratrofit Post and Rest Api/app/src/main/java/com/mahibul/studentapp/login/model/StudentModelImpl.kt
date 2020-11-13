package com.mahibul.studentapp.login.model

import android.content.Context
import com.mahibul.studentapp.R
import com.mahibul.studentapp.netword.RetrofitClint
import com.mahibul.studentapp.netword.RetrofitClintApi
import com.mahibul.studentapp.sharepreference.SharePreference
import com.mahibul.studentapp.sharepreference.SharepreferenceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentModelImpl(context : Context) : StudentModel {

    val sharepreference : SharePreference = SharepreferenceImpl(context)

    private val apinterface = RetrofitClint.getClient().create(RetrofitClintApi::class.java)

    val api_key =R.string.api_key.toString()
    override fun getToken(callback: StudentCallback<LoginResponse>) {
        /// This part is waiting for get token ......
        val dataclass = UserCredential("12345","vito@ninja")
        val call = apinterface.logIn(dataclass,api_key)
        call.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }


    override fun getStudentList(callback: StudentCallback<StudentResponse>) {
        val call = apinterface.studentList(api_key, sharepreference.gettoken(SharePreference.token)!!)
        call.enqueue(object : Callback<StudentResponse>{
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }


    override fun getStudentDetails(callback: StudentCallback<StudentResponse>) {
        val call = apinterface.studentDetails(api_key,sharepreference.gettoken(SharePreference.token)!!,sharepreference.getId(SharePreference.id))
        call.enqueue(object : Callback<StudentResponse>{
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                response.body()?.let {
                    callback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }
}