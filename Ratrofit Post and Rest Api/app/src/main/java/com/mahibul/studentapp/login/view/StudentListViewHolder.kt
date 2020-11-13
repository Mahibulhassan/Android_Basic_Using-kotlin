package com.mahibul.studentapp.login.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_student_details.view.*
import kotlinx.android.synthetic.main.studentlist.view.*

class StudentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val iv_image= itemView.iv_student_photo
    val tv_stdent_name = itemView.tv_studenname
    val tv_student_email = itemView.tv_student_email
    val tv_student_university = itemView.tv_university
}