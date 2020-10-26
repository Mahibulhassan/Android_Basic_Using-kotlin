package com.example.mvparchitecture.home.model

interface FruitCallBack {
    fun onsuccessgetdat(foodlist : MutableList<Fruit_model>)
    fun onerrorgetdata(exception : Throwable)
}