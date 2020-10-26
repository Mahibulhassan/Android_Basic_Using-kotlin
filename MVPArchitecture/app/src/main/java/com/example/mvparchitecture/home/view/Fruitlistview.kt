package com.example.mvparchitecture.home.view

import com.example.mvparchitecture.home.model.Fruit_model

interface Fruitlistview {

    fun showlist(fruitlist : MutableList<Fruit_model>)
    fun showerror(msg: String)
}