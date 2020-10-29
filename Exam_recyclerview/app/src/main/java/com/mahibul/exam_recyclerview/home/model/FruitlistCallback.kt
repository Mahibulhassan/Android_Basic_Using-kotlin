package com.example.fruitpanda.fruit_model

import com.mahibul.myapplication.home.model.Fruit

interface FruitlistCallback {
    fun onSuccess (foodlist : MutableList<Fruit>)
    fun onError (throwable: Throwable)
}