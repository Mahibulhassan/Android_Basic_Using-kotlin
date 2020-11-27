package com.mahibul.protfolioandmvvmarchitecture.core

interface NetworkCallBack<T> {

    fun onSuccess(details : T)
    fun onError(throwable: Throwable)
}