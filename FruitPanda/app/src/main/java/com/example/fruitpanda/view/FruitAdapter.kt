package com.example.fruitpanda.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fruitpanda.R
import com.example.fruitpanda.fruit_model.Fruit_model

class FruitAdapter(val foodList: MutableList<Fruit_model>) :RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foodList[position]

        Glide.with(holder.iv_food)
                .load(food.imageUrl)
                .into(holder.iv_food)
        holder.tv_food_name.text = food.name
        holder.tv_price_value.text = holder.itemView.context.getString(R.string.price_format, food.price)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}