package com.example.umte_projekt.di

import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.LoginRepoziotry
import com.example.umte_projekt.ui.async.FormLoginScreenModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val databaseModule = module {
    /*
    single {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = AppDatabase::class.java,
            name = AppDatabase.Name
        ).build()
    }*/

   // single { get<AppDatabase>().noteDao() }
}

/*val uiModule = module {
    viewModel { FormLoginScreenModel(get()) }
    viewModel { (email: String, password: String) -> FormLoginScreenModel(email = email, password = password) }
    //viewModel { DatabaseViewModel(get()) }
}*/

val dataModule = module {
    single { createLoginService() }
    single {LoginRepoziotry(get())}
}
/*
private val json = Json {
    ignoreUnknownKeys = true
}*/

fun createLoginService() = createRetrofit().create(LoginServiceAPI::class.java)

fun createRetrofit() = Retrofit.Builder().apply {
    client(OkHttpClient.Builder().build())
    baseUrl("http://imitgw.uhk.cz:59748/")
    ///addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
}.build()

