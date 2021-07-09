package com.example.vaccovid19.di

import com.example.vaccovid19.data.ApiClient
import org.koin.dsl.module

val serviceModule = module {
    single { ApiClient.retrofitBuilder() }
}
