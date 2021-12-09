package com.mahibul.dccdigitalweek.Data.Reposotory.Registration

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class RegistrModelImp : RegisterModel {
    val auth = FirebaseAuth.getInstance()

    override fun registrationUser(registerData: RegisterData, callback: DataFatchCallback<Int>) {
        auth.createUserWithEmailAndPassword(registerData.email,registerData.password).addOnCompleteListener {
            if (it.isSuccessful){
               //
                val user = auth.currentUser
                val user_id = user?.uid
                val db = FirebaseDatabase.getInstance().getReference("User").child(user_id!!)
                db.setValue(registerData).addOnCompleteListener {
                    if (it.isSuccessful){
                        callback.onError("Success")
                    }else{
                        callback.onError("failed")
                    }
                }

            }else{
                callback.onError("Registration Unsuccessful")
            }
        }
    }
}