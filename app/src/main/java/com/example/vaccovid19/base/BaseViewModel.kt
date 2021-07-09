package com.example.vaccovid19.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Thread { _error.value = throwable.message }.start()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }

}
