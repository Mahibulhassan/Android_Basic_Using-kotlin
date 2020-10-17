package com.example.recyler_view.view.home

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyler_view.R


class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivfood : AppCompatImageView = itemView.findViewById(R.id.iv_food)
    val tvFoodName: AppCompatTextView = itemView.findViewById(R.id.tv_food_name)
    val tvPriceValue: AppCompatTextView = itemView.findViewById(R.id.tv_price_value)
    val ivFavorite : AppCompatImageView = itemView.findViewById(R.id.iv_favorite)
}