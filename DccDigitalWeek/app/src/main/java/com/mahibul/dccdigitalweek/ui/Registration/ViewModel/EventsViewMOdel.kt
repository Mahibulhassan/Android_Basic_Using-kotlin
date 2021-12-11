package com.mahibul.dccdigitalweek.ui.Registration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.EventData
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.EventModel
import com.mahibul.dccdigitalweek.Data.Reposotory.Registration.EventModelImp
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class EventsViewMOdel : ViewModel() {

    val success = MutableLiveData<Int>()
    val error = MutableLiveData<String>()

    private val model : EventModel = EventModelImp()

    fun updateEvents(eventData: EventData){

        model.updateEvent(eventData,object :DataFatchCallback<Int>{
            override fun onSuccess(data: Int) {
                success.postValue(data)
            }

            override fun onError(errorMsg: String) {
                error.postValue(errorMsg)
            }
        })
    }

}