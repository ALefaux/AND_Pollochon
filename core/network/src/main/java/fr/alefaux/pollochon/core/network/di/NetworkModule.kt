package fr.alefaux.pollochon.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.alefaux.pollochon.core.network.BuildConfig
import fr.alefaux.pollochon.core.network.HelloNetworkDataSource
import fr.alefaux.pollochon.core.network.HomeNetworkDataSource
import fr.alefaux.pollochon.core.network.UserNetworkDataSource
import fr.alefaux.pollochon.core.network.PollNetworkDataSource
import fr.alefaux.pollochon.core.network.retrofit.HelloNetwork
import fr.alefaux.pollochon.core.network.retrofit.HomeNetwork
import fr.alefaux.pollochon.core.network.retrofit.UserNetwork
import fr.alefaux.pollochon.core.network.retrofit.PollNetwork
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {
    // Retrofit
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

    // Hello
    factory<HelloNetworkDataSource> { HelloNetwork(get()) }

    // Login
    factory<UserNetworkDataSource> { UserNetwork(get()) }

    // Home
    factory<HomeNetworkDataSource> { HomeNetwork(get()) }

    // Poll
    factory<PollNetworkDataSource> { PollNetwork(get()) }
}
