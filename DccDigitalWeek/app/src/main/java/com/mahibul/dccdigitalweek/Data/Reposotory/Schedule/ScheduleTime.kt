package com.mahibul.dccdigitalweek.Data.Reposotory.Schedule

data class ScheduleTime(
    val programming : String,
    val banner : String,
    val ideasub : String,
    val website : String,
    val proolym : String,
    val mock : String,
    val pricegiven : String
){
    constructor():this("","","","","","","")
}
