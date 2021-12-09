package com.mahibul.dccdigitalweek.Data.Reposotory.Registration


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class RegistrModelImp : RegisterModel {

    val auth = FirebaseAuth.getInstance()
    override fun registrationUser(registerData: RegisterData, callback: DataFatchCallback<Int>) {
        auth.createUserWithEmailAndPassword(registerData.email,registerData.password).addOnCompleteListener {
            if (it.isSuccessful){

                val user = auth.currentUser
                val user_id = user?.uid
                val db = FirebaseDatabase.getInstance().getReference("User").child(user_id!!).child("Profile")
                    db.setValue(registerData).addOnCompleteListener {
                        if (it.isSuccessful){
                            callback.onSuccess(5)
                        }else{
                            callback.onError("Authinacation Error")
                        }
                    }

                } else{
                callback.onError("Registration Unsuccessful")
            }
        }
    }
}