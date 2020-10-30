package com.mahibul.hasaner_rafkhata.home.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_itemview.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val iv_Image = itemView.iv_book
    val tv_Titel = itemView.tv_titel
    val tv_author_value= itemView.tv_author_value
    val tv_publishdate_value= itemView.tv_publishdate_value
}