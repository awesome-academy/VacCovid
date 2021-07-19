package com.sun.vaccovid19.di

import com.sun.vaccovid19.data.ApiClient
import org.koin.dsl.module

val serviceModule = module {
    single { ApiClient.retrofitBuilder() }
}
