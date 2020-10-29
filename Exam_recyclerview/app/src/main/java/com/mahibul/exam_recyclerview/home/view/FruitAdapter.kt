package com.mahibul.exam_recyclerview.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahibul.exam_recyclerview.R
import com.mahibul.myapplication.home.model.Fruit

class FruitAdapter(val foodlist : MutableList<Fruit>) : RecyclerView.Adapter<FruitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_detais,parent,false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val food = foodlist[position]

        holder.tv_name.text= food.name
        holder.tv_parice.text= food.price.toString()
        Glide.with(holder.iv_food).load(food.imageUrl).into(holder.iv_food)
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }
}