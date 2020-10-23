package com.example.fruitpanda.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitpanda.R
import com.example.fruitpanda.core.BaseActivity
import com.example.fruitpanda.fruit_model.FruitModelImp
import com.example.fruitpanda.fruit_model.Fruit_model
import com.example.fruitpanda.fruit_model.FruitlistCallback
import com.example.fruitpanda.fruit_model.FruitlistModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {
    
    override fun setLayoutId(): Int = R.layout.activity_main
    override fun setToolbar(): Toolbar{
        toolbar.title = "Fruit Panda"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress.visibility = View.VISIBLE
        showFruitlist()
    }

    private fun showFruitlist() {
        val fruitlistmodel:FruitlistModel  = FruitModelImp()
        fruitlistmodel.getFoodlist(object : FruitlistCallback{
            override fun onSuccess(foodlist: MutableList<Fruit_model>) {
                progress.visibility = View.GONE
                setadapter(foodlist)
            }

            override fun onError(throwable: Throwable) {
                progress.visibility = View.GONE
                showToast(throwable.localizedMessage)
            }
        })
    }

    private fun setadapter(foodList: MutableList<Fruit_model>){
        val adapter = FruitAdapter(foodList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}