package com.example.umte_projekt.di
import com.example.umte_projekt.data.remote.service.DepotServiceAPI
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.DepotRepozitory
import com.example.umte_projekt.data.repository.LoginRepoziotry
import com.example.umte_projekt.ui.async.*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

    val uiModuleLogin = module {
        viewModel { return@viewModel FormLoginScreenModel(get()) }

    }
val uiModuleHomeDepot = module {
    viewModel { return@viewModel DepotHomeScreenModel(get()) }
}

    val uiModuleDepot = module {
        viewModel { return@viewModel FormDepotScreenModel(get()) }
    }
        val uiModuleDepotList  = module {
        viewModel { return@viewModel PartLazyListScreenModel(get()) }

    //viewModel { DatabaseViewModel(get()) }
}
    val uiModuleAnotherUser = module {
        viewModel{ return@viewModel AnotherUserScreenModel(get()) }
    }

    val dataModuleLogin = module {
        single { createLoginService() }
        single { LoginRepoziotry(get()) }
    }

    val dataModuleDepot = module {
        single { createDepotService() }
        single { DepotRepozitory(get()) }
    }


private val json = Json {
    ignoreUnknownKeys = true
}

 fun createLoginService() = createRetrofit().create(LoginServiceAPI::class.java)

fun createDepotService() = createRetrofit().create(DepotServiceAPI::class.java)

fun createRetrofit() = Retrofit.Builder().apply {

        client(OkHttpClient.Builder().build())
        baseUrl("http://imitgw.uhk.cz:59748/")
    addConverterFactory(ScalarsConverterFactory.create())
        addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))

}.build()






