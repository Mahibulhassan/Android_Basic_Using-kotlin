package com.mahibul.firebase_pushnotificatin_analytics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging
import com.mahibul.firebase_pushnotificatin_analytics.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_topic_subscription.setOnClickListener {
            subscribeGlobalTopic()
        }
    }

    fun subscribeGlobalTopic(){
        FirebaseMessaging.getInstance().subscribeToTopic("Topic_Global")
                .addOnCompleteListener {
                    if (it.isSuccessful)
                        Toast.makeText(this,"Global topic subscription successful",Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this, it.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
        }
    }


}