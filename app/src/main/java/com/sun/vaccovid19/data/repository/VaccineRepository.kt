package com.sun.vaccovid19.data.repository

import com.sun.vaccovid19.data.VaccineDataSource
import com.sun.vaccovid19.data.model.Vaccine

class VaccineRepository(
    private val vaccineDataSourceRemote: VaccineDataSource.Remote,
    private val vaccineDataSourceLocal: VaccineDataSource.Local
) {

    suspend fun getVaccinesByCategory(category: String) =
        vaccineDataSourceRemote.getVaccinesByCategory(category)

    suspend fun getAllSavedVaccines() =
        vaccineDataSourceLocal.getAllSavedVaccines()

    suspend fun saveVaccine(vaccine: Vaccine) =
        vaccineDataSourceLocal.saveVaccine(vaccine)

    suspend fun unSaveVaccine(vaccine: Vaccine) =
        vaccineDataSourceLocal.unSaveVaccine(vaccine)

    suspend fun isVaccineSaved(name: String) =
        vaccineDataSourceLocal.isVaccineSaved(name)
}
