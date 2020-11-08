package com.example.task3project.AppPreference

import android.content.Context

class AppPreferenceImp(context: Context) :AppPreferance {

    private val sharepreferace = context.getSharedPreferences("My_Preference",Context.MODE_PRIVATE)
    private val preference = sharepreferace.edit()

    override fun setname(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun getname(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    override fun setage(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun getage(key: String):String? {
        return sharepreferace.getString(key,"")
    }

    override fun setweight(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun getweight(key: String): String? {
        return sharepreferace.getString(key,"")
    }

    override fun seturl(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun geturl(key: String): String? {
        return sharepreferace.getString(key,"")
    }
}