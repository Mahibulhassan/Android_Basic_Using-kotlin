package com.example.recyler_view.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyler_view.Data.Food
import com.example.recyler_view.R

class MyAdapterClass(private val foodlist: MutableList<Food>,private val clickListener: FoodItemClickListener) : RecyclerView.Adapter<FoodHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false)
        return FoodHolder(view)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        val food = foodlist[position]

        Glide.with(context).load(food.imageUrl).into(holder.ivfood)

        holder.tvFoodName.text = food.name
        holder.tvPriceValue.text = context.getString(R.string.price_level, food.price)

        val favoriteImageDrawableId =
            if (food.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

        holder.ivFavorite.setImageDrawable(ContextCompat.getDrawable(context, favoriteImageDrawableId))

        holder.ivfood.setOnClickListener {
            clickListener.onItemClicked(position)
        }
        holder.ivFavorite.setOnClickListener {
            clickListener.onFavoriteIconClicked(position)
        }

    }

    override fun getItemCount(): Int {
        return foodlist.size
    }
}