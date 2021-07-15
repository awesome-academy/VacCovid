package com.example.vaccovid19.data

import com.example.vaccovid19.data.model.Country

interface CountryDataSource {

    suspend fun getCountryInContinent(continent: String): List<Country>
}
