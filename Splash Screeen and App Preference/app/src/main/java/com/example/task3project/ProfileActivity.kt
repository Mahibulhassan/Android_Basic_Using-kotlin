package com.example.task3project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.task3project.AppPreference.AppPreferance
import com.example.task3project.AppPreference.AppPreferenceImp
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var appPreferance: AppPreferance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        appPreferance = AppPreferenceImp(this)
        tv_name_value.setText(appPreferance.getname(AppPreferance.Name).toString())
        tv_age_value.setText(appPreferance.getage(AppPreferance.AGE).toString())
        tv_Weight_value.setText(appPreferance.getweight(AppPreferance.Weight).toString())
        val imageurl = appPreferance.geturl(AppPreferance.Url).toString()

        Glide.with(this).load(imageurl).into(iv_glideimageid)

        profileeditid.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}