package com.sun.vaccovid19.data.repository

import com.sun.vaccovid19.data.NewsDataSource

class NewsRepository(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNews(type: String, page: String) = newsDataSource.getNews(type, page)
}
