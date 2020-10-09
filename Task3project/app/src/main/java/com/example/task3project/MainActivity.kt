package com.example.task3project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task3project.AppPreference.AppPreferance
import com.example.task3project.AppPreference.AppPreferenceImp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appPreferance: AppPreferance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appPreferance = AppPreferenceImp(this)

        appPreferance.setname(AppPreferance.Name,edtext_nameid.text.toString())
        appPreferance.setage(AppPreferance.AGE,edtext_ageid.text.toString())
        appPreferance.setweight(AppPreferance.Weight,edtext_weightid.text.toString())
        appPreferance.seturl(AppPreferance.Url,edtext_urlid.text.toString())



        savebuttonid.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

    }
}