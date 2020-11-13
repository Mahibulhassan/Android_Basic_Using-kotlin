package com.mahibul.studentapp.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.studentapp.R
import com.mahibul.studentapp.core.BaseActivity
import com.mahibul.studentapp.login.model.StudentResponse
import com.mahibul.studentapp.login.presenter.StudentPresenter
import com.mahibul.studentapp.login.presenter.StudentPresenterImpl
import com.mahibul.studentapp.sharepreference.SharePreference
import com.mahibul.studentapp.sharepreference.SharepreferenceImpl
import kotlinx.android.synthetic.main.activity_student_list.*

class StudentListActivity : BaseActivity(),StudentListView{

    val sharepreference : SharePreference = SharepreferenceImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        this.setTitle("Student List")

        val presenter : StudentPresenter = StudentPresenterImpl(this,this)
        progressbarid.visibility = View.VISIBLE
        presenter.getToken()
        presenter.getStudentList()
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun showStudentList(studentlist: StudentResponse) {
        progressbarid.visibility= View.GONE

        val data = studentlist.data
        val adapter = StudentListAdapter(this, data!!,object : ClickListner{
            override fun clickedForId(id: Int) {
                val itemid = data[id].id
                sharepreference.setId(SharePreference.id, itemid!!)
                val intent = Intent(this@StudentListActivity,StudentDetailsActivity::class.java)
                startActivity(intent)
            }
        })
        recyclerview_for_studentlist.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerview_for_studentlist.adapter = adapter
    }
}