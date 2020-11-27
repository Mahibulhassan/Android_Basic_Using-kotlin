package com.mahibul.protfolioandmvvmarchitecture.feacher.skill.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahibul.protfolioandmvvmarchitecture.R
import com.mahibul.protfolioandmvvmarchitecture.feacher.skill.model.SkillData

class SkillLIstAdapter(private val dataList : SkillData, val clickListner: ClickListner) : RecyclerView.Adapter<SkillLIstViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillLIstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listskills,parent,false)
        return SkillLIstViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillLIstViewHolder, position: Int) {
        val data = dataList[position]
        holder.tv_showList.text= data.category_name
        holder.tv_showList.setOnClickListener {
            clickListner.returnPosition(position)
        }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }
}