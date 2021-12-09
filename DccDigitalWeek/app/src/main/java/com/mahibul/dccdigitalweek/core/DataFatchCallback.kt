package com.mahibul.dccdigitalweek.core

interface DataFatchCallback<T> {

    fun onSuccess(data : T)
    fun onError (errorMsg : String)
}