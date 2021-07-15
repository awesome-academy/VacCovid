package com.example.vaccovid19.ui.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.vaccovid19.base.BaseViewModel
import com.example.vaccovid19.data.model.Country
import com.example.vaccovid19.data.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CountryViewModel(private val countryRepo: CountryRepository) : BaseViewModel() {

    private val _continent = MutableLiveData<String>()
    private val _countries = MutableLiveData<List<Country>>(emptyList())

    val countriesLiveData = Transformations.switchMap(_continent, this::getCountriesInContinent)

    private fun getCountriesInContinent(continent: String): LiveData<List<Country>> {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            _countries.postValue(countryRepo.getCountriesInContinent(continent))
        }

        return _countries
    }

    fun setContinent(continent: String) {
        _continent.value = continent
    }
}
