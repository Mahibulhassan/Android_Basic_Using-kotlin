package com.mahibul.studentapp.login.model

interface StudentModel {

    fun getToken(callback: StudentCallback<LoginResponse>)

    fun getStudentList(callback: StudentCallback<StudentResponse>)

    fun getStudentDetails (callback: StudentCallback<StudentResponse>)
}