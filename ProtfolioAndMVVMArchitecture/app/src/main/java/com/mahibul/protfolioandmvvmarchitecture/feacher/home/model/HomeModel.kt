package com.mahibul.protfolioandmvvmarchitecture.feacher.home.model

import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack

interface HomeModel {

    fun getUserDetails(callBack : NetworkCallBack<UserDetails>)
}