package com.sun.vaccovid19.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sun.vaccovid19.data.model.Vaccine

@Dao
interface VaccineDao {

    @Insert
    suspend fun saveVaccine(vaccine: Vaccine)

    @Query("DELETE FROM vaccineTbl WHERE trimedName = :name")
    suspend fun unSaveVaccine(name: String)

    @Query("SELECT * FROM vaccineTbl WHERE trimedName = :name")
    suspend fun isSaved(name: String): Vaccine

    @Query("SELECT * FROM vaccineTbl WHERE phase = :category")
    suspend fun getAllVaccinesByCategory(category: String): List<Vaccine>
}
