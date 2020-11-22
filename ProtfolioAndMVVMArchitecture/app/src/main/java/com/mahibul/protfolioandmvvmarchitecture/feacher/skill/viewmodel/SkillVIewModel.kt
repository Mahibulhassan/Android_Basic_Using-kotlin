package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillData
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillModel
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillModelImp

class SkillViewModel : ViewModel() {

    private  val model : SkillModel = SkillModelImp()

    val userdetailslivedata = MutableLiveData<SkillData>()
    val errorlivedata = MutableLiveData<Throwable>()
    fun getSkillsDetais(){

        model.getSkillDetails(object : NetworkCallBack<SkillData> {
            override fun onSuccess(details: SkillData) {
                userdetailslivedata.postValue(details)
            }

            override fun onError(throwable: Throwable) {
                errorlivedata.postValue(throwable)
            }
        })

    }
}