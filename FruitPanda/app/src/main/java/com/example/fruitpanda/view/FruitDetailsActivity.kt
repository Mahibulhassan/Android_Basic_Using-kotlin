package com.example.fruitpanda.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.fruitpanda.R
import com.example.fruitpanda.core.BaseActivity
import com.example.fruitpanda.sharePreference.SharePreference
import com.example.fruitpanda.sharePreference.ShareprefeImp
import kotlinx.android.synthetic.main.activity_fruit_details.*
import kotlinx.android.synthetic.main.toolbar.*

class FruitDetailsActivity : BaseActivity() {
    private lateinit var sharepreference: SharePreference

    override fun setLayoutId(): Int {
        return R.layout.activity_fruit_details
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = "Fruit Details"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fruitdetails()
    }

    private fun fruitdetails()
    {
        sharepreference = ShareprefeImp(this)

        val imageurl = sharepreference.geturl(SharePreference.Url).toString()
        val name = sharepreference.getname(SharePreference.Name).toString()
        val price = sharepreference.getprice(SharePreference.Price)
        val description = sharepreference.getdescrip(SharePreference.Description).toString()
        val rating = sharepreference.getrating(SharePreference.rating)
        val favoutite = sharepreference.getfavorite(SharePreference.isfavourite)

        Glide.with(applicationContext).load(imageurl).into(iv_foodlook)

        val favoriteImageDrawableId = if (favoutite!!) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
        iv_favorite.setImageDrawable(ContextCompat.getDrawable(this,favoriteImageDrawableId))
        tv_food_name.text=name
        tv_price_value.text= tv_price_value.context.getString(R.string.price_format,price)
        tv_descriptionid.text=description
        iv_favorite.setImageDrawable(ContextCompat.getDrawable(applicationContext,favoriteImageDrawableId))
        tv_raingbarid.text= rating.toString()
    }
}