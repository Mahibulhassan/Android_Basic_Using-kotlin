package com.example.retrofic_get_data.featcher.view

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.retrofic_get_data.R
import com.example.retrofic_get_data.core.BaseActivity
import com.example.retrofic_get_data.featcher.data_model.Food
import com.example.retrofic_get_data.featcher.data_model.FoodCallback
import com.example.retrofic_get_data.featcher.data_model.FoodModel
import com.example.retrofic_get_data.featcher.data_model.FoodModelImp
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showdetails()
    }

    fun showdetails(){
        progressBar.visibility = View.VISIBLE
        val homeModel: FoodModel = FoodModelImp()

        homeModel.getFoodDetails(object : FoodCallback{
            override fun onSuccess(food: Food) {
                progressBar.visibility = View.GONE
                materialCardView.visibility = View.VISIBLE

                Glide.with(iv_food)
                    .load(food.imageUrl)
                    .into(iv_food)
                tv_food_name.text = food.name
                tv_price_value.text = getString(R.string.price_format, food.price)

                val favoriteImageDrawableId = if (food.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
                iv_favorite.setImageDrawable(ContextCompat.getDrawable(applicationContext,favoriteImageDrawableId))
            }

            override fun onError(errorMessage: Throwable) {
                progressBar.visibility = View.GONE
                materialCardView.visibility = View.GONE
                showToast(errorMessage.localizedMessage)
                Logger.e(errorMessage.localizedMessage)
            }

        })

    }
}