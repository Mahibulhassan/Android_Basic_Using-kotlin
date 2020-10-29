package com.mahibul.myapplication.home.model

import java.io.Serializable

data class Fruit(
        val name: String,
        val price: Int,
        val discount: Int,
        val isFavorite: Boolean,
        val imageUrl: String,
        val rating: Float,
        val description: String
): Serializable