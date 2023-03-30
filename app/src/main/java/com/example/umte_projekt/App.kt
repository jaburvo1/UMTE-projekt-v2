package com.example.umte_projekt
import android.app.Application
import com.example.umte_projekt.di.dataModuleDepot
import com.example.umte_projekt.di.dataModuleLogin
import com.example.umte_projekt.di.uiModuleDepot
import com.example.umte_projekt.di.uiModuleLogin

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

   /*private var listOfModules :Module = module {
       single { LoginServiceAPI()}
   }*/

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(uiModuleLogin, dataModuleLogin, uiModuleDepot, dataModuleDepot))

        }
/*
        startKoin {
            androidLogger()
            androidContext(androidContext = this@App)

            modules(
                listOfModules
            )
        }

 */
    }

}