package com.example.umte_projekt
import android.app.Application
import com.example.umte_projekt.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(uiModuleLogin, dataModuleLogin, uiModuleDepot, dataModuleDepot, uiModuleHomeDepot, uiModuleDepotList, uiModuleAnotherUser))

        }

    }

}