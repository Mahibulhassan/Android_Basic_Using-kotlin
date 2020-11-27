package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model.ListSkillData
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model.SkillDataModel
import com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model.SkilldataImp

class SkillDetaisViewModel : ViewModel() {
    private val model : SkillDataModel = SkilldataImp()
    val errorlivedata = MutableLiveData<Throwable>()
    val userdetailslivedata = MutableLiveData<ListSkillData>()

    fun getSkillListDetails (){
        model.getSkillDetails(object : NetworkCallBack<ListSkillData>{
            override fun onSuccess(details: ListSkillData) {
                userdetailslivedata.postValue(details)
            }

            override fun onError(throwable: Throwable) {
                errorlivedata.postValue(throwable)
            }

        })
    }
}