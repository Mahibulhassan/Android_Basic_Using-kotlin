package com.mahibul.dccdigitalweek.Data.Reposotory.HomePage

data class User(
    val user_name : String,
    val batch : String,
    val section : String,
    val phone : String,
    val email : String,
    val password : String
){
    constructor() : this("","","","","","")
}
