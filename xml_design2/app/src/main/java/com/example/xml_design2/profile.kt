package com.example.xml_design2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        this.setTitle("Show Activity")

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)



        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val phone = intent.getStringExtra("phone")
        val weiht = intent.getStringExtra("weiht")


        tv_namevalue.text = name
        tv_agevalue.text = age
        tv_phonevalue.setText(phone)
        tv_weithvalue.text = weiht

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item)
    }

}