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

            override fun onsuccessonedata(post: Post) {
                ///Nothis to show one post......
            }

            override fun onSuccess(postlist: MutableList<Post>) {
                //for editing date...
                for(i in 0 until postlist.size){
                    postlist[i].date= editdate(postlist[i])
                    //postlist[i].date.substring(0,10)
                }
                view.showlist(postlist)
            }

            override fun onError(throwable: Throwable) {
                view.showerror(throwable.localizedMessage)
            }

        })
    }

    override fun getpost(postid : Int) {

        model.post(postid,object : NetworkCallBack{
            override fun onsuccessonedata(post: Post) {

                post.date= editdate(post)
                view.showonepost(post)
            }

            override fun onSuccess(postlist: MutableList<Post>) {
                //Nothis in the post details......
            }

            override fun onError(throwable: Throwable) {
                view.showerror(throwable.localizedMessage)
            }
        })

    }


    ///Editing date show as a format

    private fun editdate(post: Post) : String{
        return post.date.substring(0,10)
    }
}