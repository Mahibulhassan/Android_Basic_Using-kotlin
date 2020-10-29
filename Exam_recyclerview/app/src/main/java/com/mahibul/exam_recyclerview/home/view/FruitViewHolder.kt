package com.mahibul.exam_recyclerview.home.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fruit_detais.view.*

class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tv_name = itemView.tv_food_name
    val tv_parice = itemView.tv_price_value
    val iv_food = itemView.iv_food
    val iv_favourite = itemView.iv_favorite
}