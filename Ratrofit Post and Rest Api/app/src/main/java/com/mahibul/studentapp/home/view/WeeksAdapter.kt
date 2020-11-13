package com.mahibul.studentapp.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahibul.studentapp.R

class WeeksAdapter(val weeks : List<String>) : RecyclerView.Adapter<WeeksViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weekview,parent,false)
        return WeeksViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeeksViewHolder, position: Int) {
        val week = weeks[position]
        holder.tv_week.text=week
    }

    override fun getItemCount(): Int {
        return weeks.size
    }

}