package com.mahibul.dccdigitalweek.ui.Registration.ViewModel

import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.RegisterData
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.RegisterModel
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.RegistrModelImp
import com.mahibul.dccdigitalweek.core.ActivityMoVe
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class RegisterVIewModel(private val view : ActivityMoVe) {

    private val model: RegisterModel = RegistrModelImp()
    fun registerUser(registerData: RegisterData){
        model.registrationUser(registerData,object : DataFatchCallback<Int>{
            override fun onSuccess(data: Int) {
                view.moveActivity(data)
            }

            override fun onError(errorMsg: String) {
                view.errSms(errorMsg)
            }

        })

    }
}