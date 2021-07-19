package com.sun.vaccovid19.di

import com.sun.vaccovid19.ui.country.CountryViewModel
import com.sun.vaccovid19.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { CountryViewModel(get()) }
}