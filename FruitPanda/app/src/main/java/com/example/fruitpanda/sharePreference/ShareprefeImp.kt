package com.example.fruitpanda.sharePreference

import android.content.Context
import com.example.fruitpanda.view.ItemClickListner

class ShareprefeImp(context: Context):SharePreference{

    private val sharepreferace = context.getSharedPreferences("my_preference",Context.MODE_PRIVATE)
    private val preference = sharepreferace.edit()

    override fun setname(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun getname(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    override fun setprice(key: String, value: Int) {
        preference.putInt(key,value)
        preference.apply()
    }

    override fun getprice(key: String):Int? {
        return sharepreferace.getInt(key,0)
    }

    override fun setdescrip(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun getdescrip(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    override fun seturl(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun geturl(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    override fun setfavorite(key: String, value: Boolean) {
        preference.putBoolean(key,value)
        preference.apply()
    }

    override fun getfavorite(key: String): Boolean? {
        return sharepreferace.getBoolean(key,false)
    }

    override fun setrating(key: String, value: Float) {
        preference.putFloat(key,value)
        preference.apply()
    }

    override fun getrating(key: String): Float? {
        return sharepreferace.getFloat(key, 0.0F)
    }


}