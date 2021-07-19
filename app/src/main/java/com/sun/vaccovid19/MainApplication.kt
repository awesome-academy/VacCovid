package com.sun.vaccovid19

import android.app.Application
import com.sun.vaccovid19.di.repositoryModule
import com.sun.vaccovid19.di.serviceModule
import com.sun.vaccovid19.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    serviceModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}
