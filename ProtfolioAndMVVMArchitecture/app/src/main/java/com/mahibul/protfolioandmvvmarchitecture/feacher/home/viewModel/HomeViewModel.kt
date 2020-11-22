package com.mahibul.protfolioandmvvmarchitecture.feacher.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.feacher.home.model.HomeModel
import com.mahibul.protfolioandmvvmarchitecture.feacher.home.model.HomeModelImp
import com.mahibul.protfolioandmvvmarchitecture.feacher.home.model.UserDetails

class HomeViewModel : ViewModel() {

    private val model : HomeModel = HomeModelImp()

    val userdetailslivedata = MutableLiveData<UserDetails>()
    val errorlivedata = MutableLiveData<Throwable>()

    fun getUserDetails(){

        model.getUserDetails(object : NetworkCallBack<UserDetails> {
            override fun onSuccess(details: UserDetails) {
                userdetailslivedata.postValue(details)
            }

            override fun onError(throwable: Throwable) {
                errorlivedata.postValue(throwable)
            }
        })

    }
}