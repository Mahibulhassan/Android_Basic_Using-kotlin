package com.mahibul.studentapp.login.view


import android.os.Bundle
import com.bumptech.glide.Glide
import com.mahibul.studentapp.R
import com.mahibul.studentapp.core.BaseActivity
import com.mahibul.studentapp.login.model.StudentResponse
import com.mahibul.studentapp.login.presenter.StudentPresenter
import com.mahibul.studentapp.login.presenter.StudentPresenterImpl
import kotlinx.android.synthetic.main.activity_student_details.*


class StudentDetailsActivity : BaseActivity(),StudentListView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        val presenter : StudentPresenter = StudentPresenterImpl(this,this)
        presenter.getStudentDetais()
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun showStudentList(studentlist: StudentResponse) {
        val student = studentlist.data?.get(0)

        if (student != null) {
            Glide.with(this).load(student.image).into(iv_student_dtis_photo)
            tv_student_name.text= student.name
            tv_student_university.text=student.institution
            tv_student_phone.text= student.phone
            tv_student_email.text=student.email
            tv_student_description_value.text= student.biography
        }

    }

}