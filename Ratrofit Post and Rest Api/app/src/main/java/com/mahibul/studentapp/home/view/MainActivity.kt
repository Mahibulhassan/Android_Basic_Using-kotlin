package com.mahibul.studentapp.home.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.studentapp.R
import com.mahibul.studentapp.core.BaseActivity
import com.mahibul.studentapp.home.model.Course_Information
import com.mahibul.studentapp.home.presenter.Presenter
import com.mahibul.studentapp.home.presenter.PresenterImp
import com.mahibul.studentapp.login.view.StudentListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),CourseDetaisView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setTitle("Course Details")
        progressbarid.visibility = View.VISIBLE

        val presenter : Presenter = PresenterImp(this)
        presenter.getCouseInformation()

        btn_Login.setOnClickListener {
            val intent = Intent(this,StudentListActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showCouseDetails(coursedetails: Course_Information) {

        progressbarid.visibility=View.GONE

        tv_couse_name_value.text = coursedetails.data.name
        tv_couse_duration.text ="Course Duration : "+ coursedetails.data.duration
        tv_noofclass.text = "Total Class : "+coursedetails.data.number_of_class
        tv_class_duration.text ="Class Duration : "+coursedetails.data.class_duration
        tv_cousefee.text="Course Fee : "+coursedetails.data.fee
        tv_website.setOnClickListener {
            val urlvalue = coursedetails.data.url
            val url = Uri.parse(urlvalue)
            val intent = Intent(Intent.ACTION_VIEW,url)
            startActivity(intent)
        }
        val days = coursedetails.data.class_days
           showClassDays(days)
    }

    private fun showClassDays(days : List<String>) {
        val adapter = WeeksAdapter(days)
        recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter=adapter
    }
    override fun showError(msg: String) {
        showToast(msg)
    }
}