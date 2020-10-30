package com.mahibul.hasaner_rafkhata.home.model


import java.io.Serializable

data class Post (
        val id : Int,
        var date : String,
        val jetpack_featured_media_url : String,
        // val title : String
):Serializable