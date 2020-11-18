package com.mahibul.navigation_drawerfragmentactivity.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mahibul.navigation_drawerfragmentactivity.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToase(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}