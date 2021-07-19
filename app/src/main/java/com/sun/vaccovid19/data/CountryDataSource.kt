package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.Country
import com.sun.vaccovid19.data.model.CountryPerDay

interface CountryDataSource {

    suspend fun getCountryInContinent(continent: String): List<Country>

    suspend fun getCountryPerDay(symbol: String): List<CountryPerDay>
}
