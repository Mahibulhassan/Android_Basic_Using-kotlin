package com.mahibul.studentapp.login.view

import com.mahibul.studentapp.login.model.StudentResponse

interface StudentListView {
    fun showError(msg : String)
    fun showStudentList(studentlist : StudentResponse)
}