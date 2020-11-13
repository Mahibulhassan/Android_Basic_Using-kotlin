package com.mahibul.studentapp.sharepreference

import android.content.Context

class SharepreferenceImpl(context: Context)  : SharePreference {

    private val sharepreferace = context.getSharedPreferences("My_Preference",Context.MODE_PRIVATE)
    private val preference = sharepreferace.edit()

    override fun settoken(key: String, value: String) {
        preference.putString(key,value)
        preference.apply()
    }

    override fun gettoken(key: String): String? {
        return sharepreferace.getString("key","")
    }

    override fun setId(key: String, value: Int) {
        preference.putInt(key,value)
        preference.apply()
    }

    override fun getId(key: String): Int {
        return sharepreferace.getInt(key,0)
    }
}