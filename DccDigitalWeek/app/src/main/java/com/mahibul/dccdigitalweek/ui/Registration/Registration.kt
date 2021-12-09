package com.mahibul.dccdigitalweek.ui.Registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahibul.dccdigitalweek.R
import com.mahibul.dccdigitalweek.databinding.ActivityMainBinding
import com.mahibul.dccdigitalweek.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}