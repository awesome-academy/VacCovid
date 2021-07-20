package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.Vaccine

interface VaccineDataSource {

    suspend fun getVaccinesByCategory(category: String): List<Vaccine>
}
