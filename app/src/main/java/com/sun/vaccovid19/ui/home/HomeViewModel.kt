package com.sun.vaccovid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sun.vaccovid19.base.BaseViewModel
import com.sun.vaccovid19.data.model.World
import com.sun.vaccovid19.data.repository.WorldRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val worldRepository: WorldRepository) : BaseViewModel() {

    private val _worldData = MutableLiveData<World>()
    val worldData: LiveData<World>
        get() = _worldData

    init {
        getWorldData()
    }

    private fun getWorldData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _worldData.postValue(worldRepository.getWorldData())
        }
    }
}
