package com.mahibul.hasaner_rafkhata.home.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.hasaner_rafkhata.R
import com.mahibul.hasaner_rafkhata.core.BaseActivity
import com.mahibul.hasaner_rafkhata.home.model.Post
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenter
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenterImp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),PostView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : PostPresenter = PostPresenterImp(this)
        presenter.getallpostlist()
    }

    override fun showlist(postlist: MutableList<Post>) {
        setadapter(postlist)
    }

    override fun showerror(msg: String) {
        showToast(msg)
    }

    private fun setadapter(postlist : MutableList<Post>) {
        val adapter = PostAdapter(this,postlist)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

    }

}