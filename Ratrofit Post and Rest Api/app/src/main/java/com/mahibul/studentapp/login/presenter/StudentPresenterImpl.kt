package com.mahibul.studentapp.login.presenter

import android.content.Context
import com.mahibul.studentapp.login.model.*
import com.mahibul.studentapp.login.view.StudentListView
import com.mahibul.studentapp.sharepreference.SharePreference
import com.mahibul.studentapp.sharepreference.SharepreferenceImpl

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class StudentPresenterImpl(context : Context, val view : StudentListView) : StudentPresenter {

    val sharedpreference : SharePreference = SharepreferenceImpl(context)
    val model : StudentModel = StudentModelImpl(context)

    override fun getToken() {
        model.getToken(object : StudentCallback<LoginResponse> {
            override fun onSuccess(data: LoginResponse) {
                sharedpreference.settoken(SharePreference.token, data.token!!)
            }

            override fun onError(throwable: Throwable) {
                view.showError(throwable.localizedMessage)
            }
        })
    }

    override fun getStudentList() {
        model.getStudentDetails(object : StudentCallback<StudentResponse>{
            override fun onSuccess(data: StudentResponse) {
                view.showStudentList(data)
            }

            override fun onError(throwable: Throwable) {
                view.showError(throwable.localizedMessage)
            }
        })
    }

    override fun getStudentDetais() {
        model.getStudentDetails(object : StudentCallback<StudentResponse>{
            override fun onSuccess(data: StudentResponse) {
                view.showStudentList(data)
            }
            override fun onError(throwable: Throwable) {
                view.showError(throwable.localizedMessage)
            }

        })
    }
}