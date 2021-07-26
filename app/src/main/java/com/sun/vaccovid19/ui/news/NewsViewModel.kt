package com.sun.vaccovid19.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.sun.vaccovid19.base.BaseViewModel
import com.sun.vaccovid19.data.model.News
import com.sun.vaccovid19.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepo: NewsRepository) : BaseViewModel() {

    private val _news = MutableLiveData<List<News>>(emptyList())
    val news: LiveData<List<News>>

    private val _type = MutableLiveData<Pair<String, String>>()

    init {
        news = Transformations.switchMap(_type, this::getNews)
    }

    private fun getNews(typeAndPage: Pair<String, String>): LiveData<List<News>> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _news.postValue(newsRepo.getNews(typeAndPage.first, typeAndPage.second).news)
        }
        return _news
    }

    fun setNewsTypeAndPage(type: String, page: String) {
        _type.value = Pair(type, page)
    }
}
