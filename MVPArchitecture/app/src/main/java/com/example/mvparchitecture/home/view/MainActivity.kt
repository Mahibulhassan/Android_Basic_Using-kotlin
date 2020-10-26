package com.example.mvparchitecture.home.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvparchitecture.R
import com.example.mvparchitecture.core.BaseActivity
import com.example.mvparchitecture.home.model.Fruit_model
import com.example.mvparchitecture.home.presenter.Presenter
import com.example.mvparchitecture.home.presenter.PresenterImp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),Fruitlistview {
    private lateinit var presenter : Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress.visibility= View.VISIBLE
        presenter = PresenterImp(this)
        presenter.getsuccessfruitlist()
    }

    override fun showlist(fruitlist: MutableList<Fruit_model>) {
        progress.visibility = View.GONE
        fruitadapter(fruitlist)
    }

    override fun showerror(msg: String) {
        progress.visibility = View.GONE
        showToast(msg)
    }

    private fun fruitadapter(foodlist : MutableList<Fruit_model>){

        val adapter = FruitAdapter(this,foodlist)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}