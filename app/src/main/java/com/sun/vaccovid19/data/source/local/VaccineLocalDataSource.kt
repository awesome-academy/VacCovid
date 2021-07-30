package com.sun.vaccovid19.data.source.local

import com.sun.vaccovid19.data.VaccineDataSource
import com.sun.vaccovid19.data.model.Vaccine

class VaccineLocalDataSource(
    private val vaccineDao: VaccineDao
) : VaccineDataSource.Local {
    override suspend fun getAllVaccinesByCategory(category: String) =
        vaccineDao.getAllVaccinesByCategory(category)

    override suspend fun isVaccineSaved(name: String) = vaccineDao.isSaved(name)

    override suspend fun saveVaccine(vaccine: Vaccine) = vaccineDao.saveVaccine(vaccine)

    override suspend fun unSaveVaccine(name: String) = vaccineDao.unSaveVaccine(name)
}
