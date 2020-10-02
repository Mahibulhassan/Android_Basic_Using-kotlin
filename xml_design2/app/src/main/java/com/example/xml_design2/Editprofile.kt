package com.example.xml_design2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_singnup.*

class Editprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singnup)

        this.setTitle("Edit Profile")

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        btn_save.setOnClickListener{
           savedata()
        }
    }

    private fun savedata() {
        val intent = Intent(this,profile::class.java)
        val name = edi_name.getText().toString()
        val age = edi_age.getText().toString()
        val phone = edi_phone.getText().toString()
        val weiht = edi_bodywith.text.toString()

        intent.putExtra("name",name);
        intent.putExtra("age",age);
        intent.putExtra("phone",phone);
        intent.putExtra("weiht",weiht);

        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item)
    }
}