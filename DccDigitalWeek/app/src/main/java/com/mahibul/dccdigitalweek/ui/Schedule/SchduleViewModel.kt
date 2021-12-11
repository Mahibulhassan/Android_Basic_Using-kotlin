package com.mahibul.dccdigitalweek.ui.Schedule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.dccdigitalweek.Data.Reposotory.Schedule.SchduleModel
import com.mahibul.dccdigitalweek.Data.Reposotory.Schedule.SchduleModelImp
import com.mahibul.dccdigitalweek.Data.Reposotory.Schedule.ScheduleTime
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class SchduleViewModel : ViewModel() {

    val getdata = MutableLiveData<ScheduleTime>()
    val error = MutableLiveData<String>()

    private val model: SchduleModel = SchduleModelImp()

    fun getSchdule() {
        model.getSchdule(object : DataFatchCallback<ScheduleTime> {
            override fun onSuccess(data: ScheduleTime) {
                getdata.postValue(data)
            }
            override fun onError(errorMsg: String) {
                error.postValue(errorMsg)
            }

        })
    }
}