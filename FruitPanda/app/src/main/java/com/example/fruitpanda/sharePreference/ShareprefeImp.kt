package com.example.fruitpanda.sharePreference

import android.content.Context
import com.example.fruitpanda.view.ItemClickListner

class ShareprefeImp(context: Context)  {

    private val sharepreferace = context.getSharedPreferences("my_preference",Context.MODE_PRIVATE)
    private val preference = sharepreferace.edit()

    fun setname(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    fun getname(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    fun setprice(key: String, value: Int) {
        preference.putInt(key,value)
        preference.apply()
    }

    fun getprice(key: String):Int? {
        return sharepreferace.getInt(key,0)
    }

    fun setdescrip(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    fun getdescrip(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    fun seturl(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    fun geturl(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    fun setfavorite(key: String, value: Boolean) {
        preference.putBoolean(key,value)
        preference.apply()
    }

    fun getfavorite(key: String): Boolean? {
        return sharepreferace.getBoolean(key,false)
    }

    fun setrating(key: String, value: Float) {
        preference.putFloat(key,value)
        preference.apply()
    }

    fun getrating(key: String): Float? {
        return sharepreferace.getFloat(key, 0.0F)
    }


}