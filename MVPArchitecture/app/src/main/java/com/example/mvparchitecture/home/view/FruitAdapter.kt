package com.example.mvparchitecture.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvparchitecture.R
import com.example.mvparchitecture.home.model.Fruit_model

class FruitAdapter(val context : Context,val fruitlist : MutableList<Fruit_model>) : RecyclerView.Adapter<FruitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.fruit_item,parent,false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {

        val fruit = fruitlist[position]

        Glide.with(holder.imageview).load(fruit.imageUrl).into(holder.imageview)
        holder.tv_food_name.text = fruit.name
        holder.tv_price_value.text = holder.itemView.context.getString(R.string.price_format, fruit.price)

        val favoriteImageDrawableId = if (fruit.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

        holder.iv_favorite.setImageDrawable(ContextCompat.getDrawable(context,favoriteImageDrawableId))

    }

    override fun getItemCount() : Int {
        return fruitlist.size
    }

}