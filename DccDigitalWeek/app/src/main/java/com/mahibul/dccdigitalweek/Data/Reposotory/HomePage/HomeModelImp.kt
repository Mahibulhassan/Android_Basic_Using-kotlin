package com.mahibul.dccdigitalweek.Data.Reposotory.HomePage

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class HomeModelImp : HomeModel {
    override fun getUserData(callback: DataFatchCallback<User>) {
        val userpro = FirebaseAuth.getInstance().currentUser!!.uid
        val db = FirebaseDatabase.getInstance().getReference("User").child(userpro).child("Profile")

        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(User::class.java)
                callback.onSuccess(data!!)
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error.message)
            }

        })
    }
}