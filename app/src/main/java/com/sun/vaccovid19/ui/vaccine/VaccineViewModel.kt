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

    private val _remoteVaccines = MutableLiveData<List<Vaccine>>(emptyList())
    val remoteVaccines: LiveData<List<Vaccine>>

    private val _localVaccines = MutableLiveData<List<Vaccine>>(emptyList())
    val localVaccines: LiveData<List<Vaccine>>

    private val _isVaccineSaved = MutableLiveData<Vaccine>()
    val isVaccineSaved: LiveData<Vaccine>

    private val _category = MutableLiveData<String>()
    private val _pairCategory = MutableLiveData<Pair<String, String>>()
    private val _vaccineName = MutableLiveData<String>()

    init {
        remoteVaccines = Transformations.switchMap(_category, this::getVaccinesByCategory)
        isVaccineSaved = Transformations.switchMap(_vaccineName, this::isVaccineSaved)
        localVaccines = Transformations.switchMap(_pairCategory, this::getAllSavedVaccines)
    }

    private fun getVaccinesByCategory(category: String): LiveData<List<Vaccine>> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _remoteVaccines.postValue(vaccineRepo.getVaccinesByCategory(category))
        }
        return _remoteVaccines
    }

    private fun isVaccineSaved(name: String): LiveData<Vaccine> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _isVaccineSaved.postValue(vaccineRepo.isVaccineSaved(name))
        }
        return _isVaccineSaved
    }

    private fun getAllSavedVaccines(category: Pair<String, String>): LiveData<List<Vaccine>> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _localVaccines.postValue(
                vaccineRepo.getAllLocalVaccinesByCategory(category.first).plus(
                    vaccineRepo.getAllLocalVaccinesByCategory(category.second)
                )
            )
        }
        return _localVaccines
    }

    fun saveVaccine(vaccine: Vaccine) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            vaccineRepo.saveVaccine(vaccine)
        }
    }

    fun unSaveVaccine(name: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            vaccineRepo.unSaveVaccine(name)
        }
    }

    fun setVaccineRemoteCategory(category: String) {
        _category.value = category
    }

    fun setVaccineLocalCategory(pairCategory: Pair<String, String>) {
        _pairCategory.value = pairCategory
    }

    fun setVaccineName(name: String) {
        _vaccineName.value = name
    }
}
