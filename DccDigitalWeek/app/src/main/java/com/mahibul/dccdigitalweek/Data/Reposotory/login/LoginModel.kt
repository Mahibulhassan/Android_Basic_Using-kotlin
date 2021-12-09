package com.mahibul.dccdigitalweek.Data.Reposotory.login

import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginData
import com.mahibul.dccdigitalweek.core.DataFatchCallback

interface LoginModel {

    fun userLogin(loginData: LoginData, callback: DataFatchCallback<Int>)
}