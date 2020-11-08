package com.mahibul.studentapp.home.model

interface NetworkCallback {

    fun courseInformation(information : Course_Information)
    fun networkError (throwable: Throwable)
}