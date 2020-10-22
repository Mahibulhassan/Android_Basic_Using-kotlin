package com.example.foodorderapp.data_model

import java.io.Serializable

data class Food (
    val id: Int,
    val name: String,
    val price: Int,
    val isFavorite: Boolean,
    val imageUrl: String,
    val rating: Float,
    val description: String
):Serializable