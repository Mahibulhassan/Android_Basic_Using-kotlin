package com.mahibul.dccdigitalweek.ui.home

import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.HomeModel
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.HomeModelImp
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.User
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class HomeViewModel(private val view : FindData)  {

    private val model : HomeModel = HomeModelImp()

    fun getUserData(){
        model.getUserData(object : DataFatchCallback<User>{
            override fun onSuccess(data: User) {
                view.findData(data)
            }

            override fun onError(errorMsg: String) {
                view.error(errorMsg)
            }
        })

    }
}