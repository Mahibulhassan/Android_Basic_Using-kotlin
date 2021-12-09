package com.mahibul.dccdigitalweek.Data.Reposotory.login

import com.google.firebase.auth.FirebaseAuth
import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginData
import com.mahibul.dccdigitalweek.Data.Reposotory.login.LoginModel
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class LoginModelImp : LoginModel {

    val auth = FirebaseAuth.getInstance()
    override fun userLogin(loginData: LoginData, callback: DataFatchCallback<Int>) {
        auth.signInWithEmailAndPassword(loginData.email,loginData.pass).addOnCompleteListener {
            if (it.isSuccessful){
                callback.onSuccess(5)
            }else{
                callback.onError("Login Failed")
            }
        }
    }
}