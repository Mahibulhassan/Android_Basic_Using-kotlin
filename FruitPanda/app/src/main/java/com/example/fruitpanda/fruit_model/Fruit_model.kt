package com.example.fruitpanda.fruit_model

import java.io.Serializable

data class Fruit_model(
        val name: String,
        val price: Int,
        val discount: Int,
        val isFavorite: Boolean,
        val imageUrl: String,
        val rating: Float,
        val description: String
): Serializable