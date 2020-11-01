package com.mahibul.hasaner_rafkhata.home.view


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahibul.hasaner_rafkhata.R
import com.mahibul.hasaner_rafkhata.core.BaseActivity
import com.mahibul.hasaner_rafkhata.core.ClickListner
import com.mahibul.hasaner_rafkhata.home.model.Post
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenter
import com.mahibul.hasaner_rafkhata.home.presenter.PostPresenterImp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : BaseActivity(),PostView{
    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = "Hasaner Raf KHata"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() =true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val presenter : PostPresenter = PostPresenterImp(this)

        progressbarid.visibility= View.VISIBLE

        presenter.getallpostlist()
    }

    override fun showlist(postlist: MutableList<Post>) {
        progressbarid.visibility = View.GONE
        setadapter(postlist)
    }

    override fun showonepost(post: Post) {
        //Nothis to implement one data....
    }

    override fun showerror(msg: String) {
        progressbarid.visibility = View.GONE
        showToast(msg)
    }

    private fun setadapter(postlist: MutableList<Post>) {
        val adapter = PostAdapter(this, postlist, object : ClickListner {
            override fun onitemcleack(position: Int) {
                val intent = Intent(this@MainActivity, PostDetailsActivity::class.java)
                val id = postlist[position].id
                intent.putExtra("postid", id)
                startActivity(intent)
            }

        })


        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu,menu)
        return true

    }

}