package com.mahibul.hasaner_rafkhata.home.view

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahibul.hasaner_rafkhata.R
import com.mahibul.hasaner_rafkhata.core.ClickListner
import com.mahibul.hasaner_rafkhata.home.model.Post


@Suppress("DEPRECATION")
class PostAdapter(private val context : Context, private val postlist : MutableList<Post>, private val clickListner : ClickListner) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_itemview,parent,false)
        return PostViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postlist[position]

        Glide.with(context).load(post.jetpack_featured_media_url).into(holder.iv_Image)
        holder.tv_Titel.text= Html.fromHtml(post.title.rendered)
        holder.tv_author_value.text="Hasan Abdullah"
        holder.tv_publishdate_value.text= post.date

        holder.iv_Image.setOnClickListener {
            clickListner.onitemcleack(position)
        }

    }

    override fun getItemCount(): Int {
       return postlist.size
    }
}