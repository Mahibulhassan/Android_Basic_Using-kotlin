package com.mahibul.studentapp.sharepreference

interface SharePreference {

    companion object{
        const val token = "token"
        const val id = "id"
    }

    fun settoken(key: String ,value:String)
    fun gettoken(key:String):String ?

    fun setId(key : String, value : Int)
    fun getId(key: String): Int
}