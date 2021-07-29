package com.sun.vaccovid19.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sun.vaccovid19.data.model.Vaccine

@Dao
interface VaccineDao {
    @Query("SELECT * FROM vaccineTbl")
    suspend fun getAllVaccinesSaved(): List<Vaccine>

    @Insert
    suspend fun saveVaccine(vaccine: Vaccine)

    @Delete
    suspend fun unSaveVaccine(vaccine: Vaccine)

    @Query("SELECT * FROM vaccineTbl WHERE trimedName = :name")
    suspend fun isSaved(name: String): Vaccine
}
