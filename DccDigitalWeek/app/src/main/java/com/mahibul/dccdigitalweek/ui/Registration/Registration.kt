package com.mahibul.dccdigitalweek.ui.Registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.RegisterData
import com.mahibul.dccdigitalweek.MainActivity
import com.mahibul.dccdigitalweek.R
import com.mahibul.dccdigitalweek.core.ActivityMoVe
import com.mahibul.dccdigitalweek.databinding.ActivityRegistrationBinding
import com.mahibul.dccdigitalweek.ui.Registration.ViewModel.RegisterVIewModel

class Registration : AppCompatActivity(),ActivityMoVe{

    private val viewModel = RegisterVIewModel(this)

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.edtUsername.text.toString()
            val batch = binding.edtBatch.text.toString()
            val sec = binding.edtSection.text.toString().uppercase()
            val phone = binding.edtPhone.text.toString()
            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPassword.text.toString()
            val roll = binding.edtRoll.text.toString()

            if (TextUtils.isEmpty(name)|| TextUtils.isEmpty(batch)|| TextUtils.isEmpty(sec)|| TextUtils.isEmpty(phone)|| TextUtils.isEmpty(email)|| TextUtils.isEmpty(pass)|| TextUtils.isEmpty(roll)){
                Toast.makeText(this,"Requre All Field",Toast.LENGTH_LONG).show()
            }else if (pass.length < 6){
                Toast.makeText(this,"Password Must be 6 or upper",Toast.LENGTH_LONG).show()
            }else if(batch.length > 2){
                Toast.makeText(this,"2 charater like 20",Toast.LENGTH_LONG).show()
            }else if(sec.length > 1){
                Toast.makeText(this,"one word like B",Toast.LENGTH_LONG).show()
            }else if(roll.length > 3){
                Toast.makeText(this,"Maximum 3 char",Toast.LENGTH_LONG).show()
            }  else{
                viewModel.registerUser(RegisterData(name,batch,sec,phone,email,pass,roll))
            }
        }
    }

    override fun moveActivity(success: Int) {
      if(success==5){
          startActivity(Intent(this, MainActivity::class.java))
          finish()
      }
    }

    override fun errSms(errMsg: String) {
        Toast.makeText(this,errMsg,Toast.LENGTH_LONG).show()
    }

}