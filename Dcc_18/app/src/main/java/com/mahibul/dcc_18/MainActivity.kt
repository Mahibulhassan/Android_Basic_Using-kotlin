package com.mahibul.dcc_18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mahibul.dcc_18.Model.DataCallback
import com.mahibul.dcc_18.Model.DataClass
import com.mahibul.dcc_18.Model.DataModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = DataModel()

        model.getData(object  : DataCallback{
            override fun onSuccess(data: DataClass) {
                val name  = data[0].image
                Log.d("Fuck", "onSuccess: $name")
            }

            override fun onError(throwable: Throwable) {

            }

        })
    }
}