package com.mahibul.studentapp.login.model

interface StudentCallback<T> {
    fun onSuccess (data : T)
    fun onError (throwable: Throwable)
}