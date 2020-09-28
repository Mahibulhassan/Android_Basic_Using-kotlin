package com.example.xml_design2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTitle("Main Activity")

        Bt_loginid.setOnClickListener{

            logindetails()
        }

        Bt_signup.setOnClickListener{
            signupdetails()
        }

    }

    private fun signupdetails() {
        val intent = Intent(this,Editprofile::class.java)
        startActivity(intent);
    }


    private fun logindetails() {


        val email: String = Edt_emailid.getText().toString()
        val password: String = Edt_passwoedid.getText().toString()

        //Email and password validity test..
        if (email.isEmpty()) {
            Edt_emailid.setError("Enter an Email Address")
            Edt_emailid.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Edt_emailid.setError("Enter a Valid Email Address")
            Edt_emailid.requestFocus()
            return
        }

        if (password.isEmpty()) {
            Edt_passwoedid.setError("Enter an valid password")
            Edt_passwoedid.requestFocus()
            return
        }
        if (password.length < 6) {
            Edt_passwoedid.setError("Enter a Valid password")
            Edt_passwoedid.requestFocus()
            return
        }

        Toast.makeText(this,"Email and password is Valid and Signup",Toast.LENGTH_LONG).show()
    }



}