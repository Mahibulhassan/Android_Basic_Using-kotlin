package com.mahibul.studentapp.home.presenter

import com.mahibul.studentapp.home.model.Course_Information
import com.mahibul.studentapp.home.model.DataModel
import com.mahibul.studentapp.home.model.DataModelImp
import com.mahibul.studentapp.home.model.NetworkCallback
import com.mahibul.studentapp.home.view.CourseDetaisView

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class PresenterImp(val view : CourseDetaisView) : Presenter {

    private val model : DataModel = DataModelImp()

    override fun getCouseInformation() {

        model.courseInformation(object : NetworkCallback{
            override fun courseInformation(information: Course_Information) {
                view.showCouseDetails(information)
            }

            override fun networkError(throwable: Throwable) {
                view.showError(throwable.localizedMessage)
            }

        })

    }
}