package com.sun.vaccovid19.data.source.remote

import com.sun.vaccovid19.data.ApiService
import com.sun.vaccovid19.data.NewsDataSource

class NewsRemoteDataSource(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getNews(type: String, page: String) =
        apiService.getNews(type, page).first()
}
