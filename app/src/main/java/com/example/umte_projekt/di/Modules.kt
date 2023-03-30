package com.example.umte_projekt.di
import com.example.umte_projekt.data.remote.service.DepotServiceAPI
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.DepotRepozitory
import com.example.umte_projekt.data.repository.LoginRepoziotry
import com.example.umte_projekt.ui.async.FormDepotScreenModel
import com.example.umte_projekt.ui.async.FormLoginScreenModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


/*val databaseModule = module {

    single {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = AppDatabase::class.java,
            name = AppDatabase.Name
        ).build()
    }

   single { get<AppDatabase>().noteDao() }*
}
*/


    val uiModuleLogin = module {
        viewModel { return@viewModel FormLoginScreenModel(get()) }


        //viewModel { DatabaseViewModel(get()) }
    }

    val uiModuleDepot = module {
    viewModel { return@viewModel FormDepotScreenModel(get()) }


    //viewModel { DatabaseViewModel(get()) }
}

    val dataModuleLogin = module {
        single { createLoginService() }
        single { LoginRepoziotry(get()) }
    }

    val dataModuleDepot = module {
        single { createDepotService() }
        single { DepotRepozitory(get()) }
    }

/*
private val json = Json {
    ignoreUnknownKeys = true
}*/

 fun createLoginService() = createRetrofit().create(LoginServiceAPI::class.java)

fun createDepotService() = createRetrofit().create(DepotServiceAPI::class.java)

fun createRetrofit() = Retrofit.Builder().apply {

        client(OkHttpClient.Builder().build())
        baseUrl("http://imitgw.uhk.cz:59748/")
        //addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))

}.build()






