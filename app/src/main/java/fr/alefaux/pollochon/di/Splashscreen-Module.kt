package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.BuildConfig
import fr.alefaux.pollochon.network.countries.CountriesNetwork
import fr.alefaux.pollochon.network.countries.CountriesNetworkImpl
import fr.alefaux.pollochon.repositories.CountriesRepository
import fr.alefaux.pollochon.repositories.CountriesRepositoryImpl
import fr.alefaux.pollochon.services.CountriesService
import fr.alefaux.pollochon.usecase.CountriesUseCase
import fr.alefaux.pollochon.usecase.CountriesUseCaseImpl
import fr.alefaux.pollochon.views.splashscreen.SplashscreenViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT_DURATION: Long = 60
val splashscreenModule = module {
    viewModel { SplashscreenViewModel(get(), get()) }

    single { CountriesUseCaseImpl(get()) as CountriesUseCase }
    single { CountriesRepositoryImpl(get()) as CountriesRepository }
    single { CountriesNetworkImpl(get()) as CountriesNetwork }

    single {
        val okHttpClientBuilder = OkHttpClient
            .Builder()
            .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logInterceptor)
        }

        return@single okHttpClientBuilder.build()
    }

    single {
        return@single Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/")
            .client(get() as OkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CountriesService::class.java)
    }
}