package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model

class SkillData : ArrayList<SkillData.SkillDataItem>(){
    data class SkillDataItem(
        val category_name: String,
        val skills: List<String>
    )
}