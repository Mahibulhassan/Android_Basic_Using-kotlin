package com.example.fruitpanda.view


import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.fruitpanda.R
import com.example.fruitpanda.core.BaseActivity
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

    }
}