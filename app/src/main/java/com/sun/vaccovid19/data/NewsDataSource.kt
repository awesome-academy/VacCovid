package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.NewsResponse

interface NewsDataSource {

    suspend fun getNews(type: String, page: String): NewsResponse
}
