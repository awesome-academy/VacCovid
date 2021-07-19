package com.sun.vaccovid19.di


import com.sun.vaccovid19.data.CountryDataSource
import com.sun.vaccovid19.data.WordDataSource
import com.sun.vaccovid19.data.repository.CountryRepository
import com.sun.vaccovid19.data.repository.WorldRepository
import com.sun.vaccovid19.data.source.remote.CountryRemoteDataSource
import com.sun.vaccovid19.data.source.remote.WorldRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<WordDataSource> { WorldRemoteDataSource(get()) }
    single<CountryDataSource> { CountryRemoteDataSource(get()) }
    single { WorldRepository(get()) }
    single { CountryRepository(get()) }
}
