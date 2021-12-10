package com.mahibul.dccdigitalweek.ui.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.HomeModel
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.HomeModelImp
import com.mahibul.dccdigitalweek.Data.Reposotory.HomePage.User
import com.mahibul.dccdigitalweek.core.DataFatchCallback

class HomeViewModel() : ViewModel(){

    val dataUs = MutableLiveData<User>()
    val error = MutableLiveData<String>()

    private val model : HomeModel = HomeModelImp()

    fun getUserData(){
        model.getUserData(object : DataFatchCallback<User>{
            override fun onSuccess(data: User) {
                dataUs.postValue(data)
            }

            override fun onError(errorMsg: String) {
                error.postValue(errorMsg)
            }
        })

    }
}