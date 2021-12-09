package com.mahibul.dccdigitalweek.ui.Registration.ViewModel

import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginData
import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginModel
import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginModelImp
import com.mahibul.dccdigitalweek.core.ActivityMoVe
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class LoginViewModel(private val view : ActivityMoVe) {

    private val model : LoginModel = LoginModelImp()

    fun userLogin(loginData: LoginData) {
        model.userLogin(loginData,object : DataFatchCallback<Int>{
            override fun onSuccess(data: Int) {
                view.moveActivity(data)
            }

            override fun onError(errorMsg: String) {
               view.errSms(errorMsg)
            }

        })
    }

}