package com.mahibul.studentapp.login.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahibul.studentapp.R
import com.mahibul.studentapp.login.model.Data

class StudentListAdapter(val context: Context,val studentlist : List<Data>,val clicklistner : ClickListner) : RecyclerView.Adapter<StudentListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.studentlist,parent,false)
        return StudentListViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        val student = studentlist[position]
        Glide.with(holder.iv_image).load(student.image).into(holder.iv_image)
        holder.tv_stdent_name.text = student.name
        holder.tv_student_email.text = student.email
        holder.tv_student_university.text = student.institution

        holder.tv_stdent_name.setOnClickListener {
            clicklistner.clickedForId(position)
        }
    }

    override fun getItemCount(): Int {
        return studentlist.size
    }
}