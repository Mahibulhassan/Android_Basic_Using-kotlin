package com.example.fruitpanda.fruit_model

interface FruitlistCallback {

    fun onSuccess (foodlist : MutableList<Fruit_model>)
    fun onError (throwable: Throwable)
}