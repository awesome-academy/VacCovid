package com.sun.vaccovid19.data.repository

import com.sun.vaccovid19.data.VaccineDataSource

class VaccineRepository(
    private val vaccineDataSource: VaccineDataSource
) {

    suspend fun getVaccinesByCategory(category: String) =
        vaccineDataSource.getVaccinesByCategory(category)
}
