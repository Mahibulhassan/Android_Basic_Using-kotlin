package com.mahibul.protfolioandmvvmarchitecture.feacher.skillDetailsShow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahibul.protfolioandmvvmarchitecture.R

class SkillLIstDataAdapter(val datalist : List<String>) :RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listskills,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datalist[position]
        holder.tv_showList.text=data
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}