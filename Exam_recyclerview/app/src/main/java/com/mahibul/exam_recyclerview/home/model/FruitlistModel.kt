package com.mahibul.fruitpanda.fruit_model

import com.example.fruitpanda.fruit_model.FruitlistCallback

interface FruitlistModel {
    fun getFoodlist (fruitlistCallback: FruitlistCallback)
}