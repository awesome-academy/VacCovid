package com.sun.vaccovid19.di


import com.sun.vaccovid19.data.CountryDataSource
import com.sun.vaccovid19.data.NewsDataSource
import com.sun.vaccovid19.data.VaccineDataSource
import com.sun.vaccovid19.data.WordDataSource
import com.sun.vaccovid19.data.repository.CountryRepository
import com.sun.vaccovid19.data.repository.NewsRepository
import com.sun.vaccovid19.data.repository.VaccineRepository
import com.sun.vaccovid19.data.repository.WorldRepository
import com.sun.vaccovid19.data.source.remote.CountryRemoteDataSource
import com.sun.vaccovid19.data.source.remote.NewsRemoteDataSource
import com.sun.vaccovid19.data.source.remote.VaccineRemoteDataSource
import com.sun.vaccovid19.data.source.remote.WorldRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<WordDataSource> { WorldRemoteDataSource(get()) }
    single<CountryDataSource> { CountryRemoteDataSource(get()) }
    single<VaccineDataSource> { VaccineRemoteDataSource(get()) }
    single<NewsDataSource> { NewsRemoteDataSource(get()) }

    single { WorldRepository(get()) }
    single { CountryRepository(get()) }
    single { VaccineRepository(get()) }
    single { NewsRepository(get()) }
}
