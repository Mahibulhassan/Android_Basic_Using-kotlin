package com.example.fruitpanda.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fruit_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val iv_food : ImageView = itemView.iv_food
    val tv_food_name: TextView = itemView.tv_food_name
    val tv_price_value : TextView = itemView.tv_price_value
    val iv_favorite : ImageView = itemView.iv_favorite
}