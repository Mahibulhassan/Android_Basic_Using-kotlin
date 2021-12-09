package com.mahibul.dccdigitalweek.ui.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahibul.dccdigitalweek.MainActivity
import com.mahibul.dccdigitalweek.R
import com.mahibul.dccdigitalweek.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
          //  startActivity(Intent(this,MainActivity::class.java))

        }
        binding.btnRegistration.setOnClickListener {
            startActivity(Intent(this,Registration::class.java))
        }

    }
}