package com.example.vaccovid19.di

import com.example.vaccovid19.data.CountryDataSource
import com.example.vaccovid19.data.WordDataSource
import com.example.vaccovid19.data.repository.CountryRepository
import com.example.vaccovid19.data.repository.WorldRepository
import com.example.vaccovid19.data.source.remote.CountryRemoteDataSource
import com.example.vaccovid19.data.source.remote.WorldRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<WordDataSource> { WorldRemoteDataSource(get()) }
    single<CountryDataSource> {CountryRemoteDataSource(get())}
    single { WorldRepository(get()) }
    single {CountryRepository(get())}
}
