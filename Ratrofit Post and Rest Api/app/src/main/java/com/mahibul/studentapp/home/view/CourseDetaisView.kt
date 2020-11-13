package com.mahibul.studentapp.home.view

import com.mahibul.studentapp.home.model.Course_Information

interface CourseDetaisView {

    fun showCouseDetails(coursedetails : Course_Information)
    fun showError(msg : String)
}