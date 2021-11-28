package com.mahibul.dcc_18.Model

interface DataCallback {

    fun onSuccess(data : DataClass)
    fun onError (throwable: Throwable)
}