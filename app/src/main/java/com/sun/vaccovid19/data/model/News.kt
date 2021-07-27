package com.sun.vaccovid19.data.model

import androidx.recyclerview.widget.DiffUtil
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
) {
    companion object {
        fun getNewsDiffUtil() = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: News, newItem: News) =
                oldItem == newItem

        }
    }
}
