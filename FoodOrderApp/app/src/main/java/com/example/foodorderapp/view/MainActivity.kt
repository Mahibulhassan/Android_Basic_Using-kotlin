package com.example.foodorderapp.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.foodorderapp.R
import com.example.foodorderapp.core.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main
    override fun setToolbar(): Toolbar {
        toolbar.title = "Food App"
        return toolbar
    }


    override val isHomeUpButtonEnable: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  showFoodDetails()
    }
}