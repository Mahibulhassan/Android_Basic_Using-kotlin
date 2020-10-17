package com.example.recyler_view.view.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyler_view.Data.FoodModel
import com.example.recyler_view.Data.FoodModelImp
import com.example.recyler_view.R
import com.example.recyler_view.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
        override fun setLayoutId(): Int {
            return R.layout.activity_main
        }
    private lateinit var foodModel: FoodModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showfoodlist()
    }

    private fun showfoodlist() {
        foodModel = FoodModelImp()
        val foodlist = foodModel.getFoodList()

        val adapter = MyAdapterClass(foodlist,object : FoodItemClickListener{
            override fun onItemClicked(position: Int) {
                showtoast(foodlist[position].name)
            }

            override fun onFavoriteIconClicked(position: Int) {
                showtoast(position.toString())
            }
        })

        recycleviewid.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recycleviewid.adapter = adapter

    }

}
