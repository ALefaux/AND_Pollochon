package fr.alefaux.pollochon.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.alefaux.pollochon.core.network.BuildConfig
import fr.alefaux.pollochon.core.network.HelloNetworkDataSource
import fr.alefaux.pollochon.core.network.LoginNetworkDataSource
import fr.alefaux.pollochon.core.network.retrofit.HelloNetwork
import fr.alefaux.pollochon.core.network.retrofit.LoginNetwork
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {
    single<Call.Factory> {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        if (BuildConfig.DEBUG) {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    },
            )
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://pollochon-dev.onrender.com")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .callFactory(get())
            .build()
    }

    factoryOf(::HelloNetwork) bind HelloNetworkDataSource::class
    factoryOf(::LoginNetwork) bind LoginNetworkDataSource::class
}
