package com.mahibul.dccdigitalweek.Data.Reposotory.Registration

import com.mahibul.dccdigitalweek.core.DataFatchCallback

interface EventModel {

    fun updateEvent(eventData: EventData,callback: DataFatchCallback<Int>)
}