package com.example.recyler_view.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity () {
    abstract fun setLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
    }

    fun showtoast(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}