package com.mahibul.exam_recyclerview.home.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitpanda.fruit_model.FruitModelImp
import com.example.fruitpanda.fruit_model.FruitlistCallback
import com.mahibul.exam_recyclerview.R
import com.mahibul.exam_recyclerview.core.BaseActivity
import com.mahibul.fruitpanda.fruit_model.FruitlistModel
import com.mahibul.myapplication.home.model.Fruit
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setdata()
    }

    private fun setdata() {
        val model : FruitlistModel = FruitModelImp()

        model.getFoodlist(object : FruitlistCallback{
            override fun onSuccess(foodlist: MutableList<Fruit>) {
                setadapter(foodlist)
            }

            override fun onError(throwable: Throwable) {
                showToast(throwable.localizedMessage)
            }

        })
    }

    fun setadapter(foodlist : MutableList<Fruit>){

        val adapter = FruitAdapter(foodlist)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter= adapter
    }
}