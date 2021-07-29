package com.sun.vaccovid19.di

import com.sun.vaccovid19.data.ApiClient
import com.sun.vaccovid19.data.RetrofitBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val serviceModule = module {
    single { ApiClient.retrofitBuilder() }
    single { RetrofitBuilder.getVaccineDao(androidContext()) }
}
