package com.mahibul.dccdigitalweek.Data.Reposotory.Schedule

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class SchduleModelImp :SchduleModel {

    override fun getSchdule(callback: DataFatchCallback<ScheduleTime>) {

        val db1 = FirebaseDatabase.getInstance().getReference("eventTime")
        db1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(ScheduleTime::class.java)
                callback.onSuccess(data!!)
            }

            override fun onCancelled(error: DatabaseError) {
               callback.onError(error.message)
            }

        })
    }
}