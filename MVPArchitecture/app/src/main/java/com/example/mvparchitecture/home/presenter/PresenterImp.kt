package com.example.mvparchitecture.home.presenter

import com.example.mvparchitecture.home.model.FruitCallBack
import com.example.mvparchitecture.home.model.FruitModel
import com.example.mvparchitecture.home.model.FruitModelimp
import com.example.mvparchitecture.home.model.Fruit_model
import com.example.mvparchitecture.home.view.Fruitlistview

class PresenterImp(private val view : Fruitlistview) : Presenter {

    private val foodlistmodel : FruitModel = FruitModelimp()

    override fun getsuccessfruitlist() {
        foodlistmodel.details(object : FruitCallBack{
            override fun onsuccessgetdat(foodlist: MutableList<Fruit_model>) {
                view.showlist(foodlist)
            }

            override fun onerrorgetdata(exception: Throwable) {
                view.showerror(exception.localizedMessage)
            }

        })
    }
}