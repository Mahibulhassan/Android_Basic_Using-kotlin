package com.example.fruitpanda.view

import android.content.Context
import android.content.Intent
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
import com.example.fruitpanda.sharePreference.SharePreference
import com.example.fruitpanda.sharePreference.ShareprefeImp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : BaseActivity() {

    private lateinit var sharepreference : SharePreference

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
        val adapter = FruitAdapter(this,foodList,object : ItemClickListner{
            override fun onItemclick(position: Int) {
                sharepreference =ShareprefeImp(this@MainActivity)
                sharepreference.setname(SharePreference.Name,foodList[position].name)
                sharepreference.setprice(SharePreference.Price,foodList[position].price)
                sharepreference.setdescrip(SharePreference.Description,foodList[position].description)
                sharepreference.setfavorite(SharePreference.isfavourite,foodList[position].isFavorite)
                sharepreference.seturl(SharePreference.Url,foodList[position].imageUrl)
                sharepreference.setrating(SharePreference.rating,foodList[position].rating)

                val intent = Intent(this@MainActivity,FruitDetailsActivity::class.java)
                startActivity(intent)

            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}