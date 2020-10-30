package com.mahibul.hasaner_rafkhata.core

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

 abstract class BaseActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
     }

     fun showToast(text : String){
         Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
     }
}