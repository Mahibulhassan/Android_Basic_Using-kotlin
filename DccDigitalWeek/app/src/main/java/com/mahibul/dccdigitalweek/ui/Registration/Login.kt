package com.mahibul.dccdigitalweek.ui.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginData
import com.mahibul.dccdigitalweek.MainActivity
import com.mahibul.dccdigitalweek.R
import com.mahibul.dccdigitalweek.core.ActivityMoVe
import com.mahibul.dccdigitalweek.databinding.ActivityLoginBinding
import com.mahibul.dccdigitalweek.ui.Registration.ViewModel.LoginViewModel

class Login : AppCompatActivity(),ActivityMoVe{

    private lateinit var binding: ActivityLoginBinding
    private val viewModel = LoginViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
          //  startActivity(Intent(this,MainActivity::class.java))
            val email = binding.emailId.text.toString()
            val pass = binding.passwordId.text.toString()
            if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(pass)){
                Toast.makeText(this,"Login Faliled",Toast.LENGTH_LONG).show()
            }else
            viewModel.userLogin(LoginData(email,pass))
        }
        binding.btnRegistration.setOnClickListener {
            startActivity(Intent(this,Registration::class.java))
        }
    }

    override fun moveActivity(success: Int) {
       if (success == 5){
           startActivity(Intent(this,MainActivity::class.java))
       }
    }

    override fun errSms(errMsg: String) {
        Toast.makeText(this,errMsg,Toast.LENGTH_LONG).show()
    }
}