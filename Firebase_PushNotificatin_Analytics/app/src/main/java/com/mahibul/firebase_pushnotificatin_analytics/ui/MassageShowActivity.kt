package com.mahibul.firebase_pushnotificatin_analytics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.mahibul.firebase_pushnotificatin_analytics.R
import kotlinx.android.synthetic.main.activity_massage_show.*

class MassageShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_massage_show)
        showNotificationData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = NavUtils.getParentActivityIntent(this)
        startActivity(intent)
    }

    private fun showNotificationData() {
        val title = intent.getStringExtra("title")
        val timeStampString = intent.getStringExtra("timestamp")
        val articleString = intent.getStringExtra("article_data")
        val imageUrl = intent.getStringExtra("image")

        Glide.with(featureGraphics)
                .load(imageUrl)
                .error(R.drawable.image_placeholder)
                .into(featureGraphics)

        header.text = title
        timeStamp.text = timeStampString
        article.text = articleString
    }
}