package com.sun.vaccovid19.data

import com.sun.vaccovid19.data.model.Vaccine

interface VaccineDataSource {

    interface Remote {
        suspend fun getVaccinesByCategory(category: String): List<Vaccine>
    }

    interface Local {
        suspend fun getAllSavedVaccines(): List<Vaccine>
        suspend fun isVaccineSaved(name: String): Vaccine
        suspend fun saveVaccine(vaccine: Vaccine)
        suspend fun unSaveVaccine(vaccine: Vaccine)
    }
}
