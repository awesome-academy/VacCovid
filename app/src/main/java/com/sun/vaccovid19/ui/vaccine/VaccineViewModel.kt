package com.sun.vaccovid19.ui.vaccine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.sun.vaccovid19.base.BaseViewModel
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.data.repository.VaccineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VaccineViewModel(private val vaccineRepo: VaccineRepository) : BaseViewModel() {

    private val _vaccines = MutableLiveData<List<Vaccine>>(emptyList())
    val vaccines: LiveData<List<Vaccine>>

    private val _category = MutableLiveData<String>()

    init {
        vaccines = Transformations.switchMap(_category, this::getVaccinesByCategory)
    }

    private fun getVaccinesByCategory(category: String): LiveData<List<Vaccine>> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _vaccines.postValue(vaccineRepo.getVaccinesByCategory(category))
        }
        return _vaccines
    }

    fun setVaccineCategory(category: String) {
        _category.value = category
    }
}
