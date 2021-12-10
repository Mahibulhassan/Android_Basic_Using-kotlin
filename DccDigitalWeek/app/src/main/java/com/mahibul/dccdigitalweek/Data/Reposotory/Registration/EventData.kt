package com.mahibul.dccdigitalweek.Data.Reposotory.Registration

data class EventData(
    val event1 :String,
    val event2 : String,
    val event3 : String,
    val event1position :String,
    val event2position : String,
    val event3position : String
){
    constructor():this("","","","","","")
}
