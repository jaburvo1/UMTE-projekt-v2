package com.example.umte_projekt.di
/*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import cz.uhk.umte.ui.async.launches.RocketLaunchesViewModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val uiModule = module {
    viewModel { RocketLaunchesViewModel(get()) }
}

val dataModule = module {
    single { createSpaceXService() }
    single { SpaceXRepository(get()) }
}

private val json = Json {
    ignoreUnknownKeys = true
}

fun createSpaceXService() = createRetrofit().create(SpaceXAPIService::class.java)

fun createRetrofit() = Retrofit.Builder().apply {
    client(OkHttpClient.Builder().build())
    baseUrl("https://api.spacexdata.com/v3/")
    addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
}.build()
*/