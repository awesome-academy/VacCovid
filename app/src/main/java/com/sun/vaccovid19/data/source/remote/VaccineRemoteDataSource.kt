package com.sun.vaccovid19.data.source.remote

import com.sun.vaccovid19.data.ApiService
import com.sun.vaccovid19.data.VaccineDataSource

class VaccineRemoteDataSource(
    private val apiService: ApiService
) : VaccineDataSource {

    override suspend fun getVaccinesByCategory(category: String) =
        apiService.getVaccinesByCategory(category)
}
