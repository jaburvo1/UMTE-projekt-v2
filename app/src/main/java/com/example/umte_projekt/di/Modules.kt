package com.example.umte_projekt.di

import com.example.umte_projekt.data.remote.service.DepotService
import com.example.umte_projekt.data.remote.service.LoginService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit


val uiModule = module {
    viewModel { RocketLaunchesViewModel(get()) }
}

val dataModule = module {
    single { createLoginService()}
    single { SpaceXRepository(get()) }
}

private val json = Json {
    ignoreUnknownKeys = true
}

fun createLoginService() = createRetrofit().create(LoginService::class.java)

fun createDepotService() = createRetrofit().create(DepotService::class.java)

fun createRetrofit() = Retrofit.Builder().apply {
    client(OkHttpClient.Builder().build())
    baseUrl("https://api.spacexdata.com/v3/")
    addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
}.build()
