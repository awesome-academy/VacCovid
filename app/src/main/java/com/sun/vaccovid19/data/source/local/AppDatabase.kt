package com.sun.vaccovid19.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sun.vaccovid19.data.model.Vaccine
import com.sun.vaccovid19.data.source.local.AppDatabase.Companion.DATABASE_VERSION
import com.sun.vaccovid19.data.source.local.AppDatabase.Companion.EXPORT_SCHEME

@Database(
    entities = [Vaccine::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getVaccinesDao(): VaccineDao

    companion object {
        const val DATABASE_NAME = "CovidDB"
        const val DATABASE_VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
