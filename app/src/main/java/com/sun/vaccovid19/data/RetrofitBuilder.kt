package com.sun.vaccovid19.data

import android.content.Context
import androidx.room.Room
import com.sun.vaccovid19.data.source.local.AppDatabase
import com.sun.vaccovid19.data.source.local.AppDatabase.Companion.DATABASE_NAME

object RetrofitBuilder {
    fun getVaccineDao(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build().getVaccinesDao()
}
