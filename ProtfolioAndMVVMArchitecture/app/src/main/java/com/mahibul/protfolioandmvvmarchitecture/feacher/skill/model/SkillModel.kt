package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model

import com.mahibul.protfolioandmvvmarchitecture.core.NetworkCallBack

interface SkillModel {

    fun getSkillDetails(callback : NetworkCallBack<SkillData>)
}