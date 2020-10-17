package com.example.recyler_view.Data

interface FoodModel {

    fun getFoodList () : MutableList<Food>
    fun getFoodItemById (item : Int) : Food
}