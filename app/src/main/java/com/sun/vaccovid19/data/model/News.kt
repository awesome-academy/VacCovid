package com.sun.vaccovid19.data.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("news_id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("urlToImage")
    val url: String,
    @SerializedName("pubDate")
    val date: String,
    @SerializedName("reference")
    val reference: String
)
