package com.mahibul.dccdigitalweek.ui.home

import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.User

interface FindData {

    fun findData(data : User)
    fun error (error : String)
}