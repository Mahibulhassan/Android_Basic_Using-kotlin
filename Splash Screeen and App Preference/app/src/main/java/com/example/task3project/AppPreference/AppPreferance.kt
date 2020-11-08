package com.example.task3project.AppPreference

interface AppPreferance {

    companion object{
        const val Name = "name"
        const val AGE =  "age"
        const val Weight ="Weight"
        const val Url = "url"
    }

    fun setname(key: String ,value:String)
    fun getname(key:String):String?
    fun setage(key:String,value:String)
    fun getage(key:String):String?
    fun setweight(key:String,value:String)
    fun getweight(key:String):String?
    fun seturl(key:String,value:String)
    fun geturl(key:String):String?
}