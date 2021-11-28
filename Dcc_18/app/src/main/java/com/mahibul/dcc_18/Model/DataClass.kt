package com.mahibul.dcc_18.Model

class DataClass : ArrayList<DataClass.DataClassItem>(){
    data class DataClassItem(
        val created_at: String,
        val id: Int,
        val image: String,
        val name: String,
        val parent_id: Int,
        val position: Int,
        val status: Int,
        val updated_at: String
    )
}