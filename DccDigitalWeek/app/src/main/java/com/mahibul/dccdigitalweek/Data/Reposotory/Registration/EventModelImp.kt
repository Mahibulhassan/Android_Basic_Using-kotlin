package com.mahibul.dccdigitalweek.Data.Reposotory.Registration

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class EventModelImp : EventModel {
    val auth = FirebaseAuth.getInstance()
    override fun updateEvent(eventData: EventData, callback: DataFatchCallback<Int>) {
        val user = auth.currentUser
        val user_id = user?.uid
        val db1 = FirebaseDatabase.getInstance().getReference("User").child(user_id!!).child("events")
        db1.setValue(eventData).addOnCompleteListener {
            if (it.isSuccessful){
                callback.onSuccess(5)
            }else{
                callback.onError("Submit Failed")
            }
        }
    }

}