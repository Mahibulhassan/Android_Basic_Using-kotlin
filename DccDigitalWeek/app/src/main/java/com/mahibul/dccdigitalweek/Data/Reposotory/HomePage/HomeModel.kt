package com.mahibul.dccdigitalweek.Data.Reposotory.HomePage

import com.mahibul.dccdigitalweek.core.DataFatchCallback

interface HomeModel {
    fun getUserData(callback: DataFatchCallback<User>)
}