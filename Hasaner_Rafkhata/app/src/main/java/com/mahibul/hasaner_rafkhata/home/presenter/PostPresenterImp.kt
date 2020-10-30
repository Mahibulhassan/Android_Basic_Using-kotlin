package com.mahibul.hasaner_rafkhata.home.presenter

import com.mahibul.hasaner_rafkhata.home.model.NetworkCallBack
import com.mahibul.hasaner_rafkhata.home.model.Post
import com.mahibul.hasaner_rafkhata.home.model.PostModel
import com.mahibul.hasaner_rafkhata.home.model.PostModelImp
import com.mahibul.hasaner_rafkhata.home.view.PostView

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class PostPresenterImp(val view : PostView) : PostPresenter {

    private val model : PostModel = PostModelImp()

    override fun getallpostlist() {
        model.postlistdetails(object : NetworkCallBack{
            override fun onSuccess(postlist: MutableList<Post>) {
                //for editing date...
                editdate(postlist)
            }

            override fun onError(throwable: Throwable) {
                view.showerror(throwable.localizedMessage)
            }

        })
    }



    ///Editing date show as a format

    private fun editdate(postlist: MutableList<Post>) {

        for(i in 0..postlist.size-1){
            postlist[i].date= postlist[i].date.substring(0,10)
        }
        view.showlist(postlist)
    }
}