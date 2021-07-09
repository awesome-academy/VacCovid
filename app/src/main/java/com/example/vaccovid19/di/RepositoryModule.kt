package com.example.vaccovid19.di

import com.example.vaccovid19.data.WordDataSource
import com.example.vaccovid19.data.repository.WorldRepository
import com.example.vaccovid19.data.source.remote.WorldRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<WordDataSource> { WorldRemoteDataSource(get()) }
    single { WorldRepository(get()) }
}
