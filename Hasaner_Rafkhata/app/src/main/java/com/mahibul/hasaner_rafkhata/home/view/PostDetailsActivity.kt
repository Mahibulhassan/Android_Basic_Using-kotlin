package com.mahibul.hasaner_rafkhata.home.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.mahibul.hasaner_rafkhata.R
import com.mahibul.hasaner_rafkhata.core.BaseActivity
import com.mahibul.hasaner_rafkhata.home.model.Post
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenter
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenterImp
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.toolbar.*

@Suppress("DEPRECATION")
class PostDetailsActivity : BaseActivity(),PostView {
    override fun setLayoutId(): Int {
        return R.layout.activity_post_details
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = "Post"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postid=intent.getIntExtra("postid",0)

        val presenter : PostPresenter = PostPresenterImp(this)
        progressbarid.visibility = View.VISIBLE

        presenter.getpost(postid)
    }


    override fun showlist(postlist: MutableList<Post>) {
        //Nothig to implement in the list
    }

    @SuppressLint("SetTextI18n")
    override fun showonepost(post: Post) {
        progressbarid.visibility = View.GONE

        materialcardview.visibility = View.VISIBLE

        Glide.with(this).load(post.jetpack_featured_media_url).into(iv_book)
        tv_titel.text= Html.fromHtml(post.title.rendered)
        tv_author_value.text="Hasan Abdullah"
        tv_publishdate_value.text= post.date
        tv_description.text = Html.fromHtml(post.content.rendered)
    }

    override fun showerror(msg: String) {
        progressbarid.visibility = View.GONE
        showToast(msg)
    }
}