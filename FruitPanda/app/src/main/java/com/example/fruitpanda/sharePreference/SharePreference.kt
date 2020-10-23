package com.example.fruitpanda.sharePreference

interface SharePreference {
    companion object{
        const val Name = "name"
        const val Price =  "Price"
        const val Description ="desk"
        const val Url = "url"
        const val isfavourite = "favorite"
        const val rating = "rating"
    }

    fun setname(key: String ,value:String)
    fun getname(key:String):String?
    fun setprice(key:String,value:Int)
    fun getprice(key:String):Int?
    fun setdescrip(key:String,value:String)
    fun getdescrip(key:String):String?
    fun seturl(key:String,value:String)
    fun geturl(key:String):String?
    fun setfavorite(key:String,value:Boolean)
    fun getfavorite(key:String):Boolean?
    fun setrating(key:String,value: Float)
    fun getrating(key:String):Float?
}