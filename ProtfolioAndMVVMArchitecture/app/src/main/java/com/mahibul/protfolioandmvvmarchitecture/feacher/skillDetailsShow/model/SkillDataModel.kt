package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model

import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack


interface SkillDataModel {
    fun getSkillDetails(callback : NetworkCallBack<ListSkillData>)
}