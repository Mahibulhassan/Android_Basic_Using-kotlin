package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.model

class ListSkillData : ArrayList<ListSkillData.ListSkillDataItem>(){
    data class ListSkillDataItem(
        val category_name: String,
        val skills: List<String>
    )
}