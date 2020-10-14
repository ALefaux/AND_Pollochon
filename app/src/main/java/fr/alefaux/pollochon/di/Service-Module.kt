package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.BuildConfig
import fr.alefaux.pollochon.services.PollService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIMEOUT_DURATION: Long = 60

val serviceModule = module {
    single {
        val okHttpClientBuilder = OkHttpClient
            .Builder()
            .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)

        okHttpClientBuilder
            .addInterceptor { interceptor ->
                val requestBuilder = interceptor.request().newBuilder()
                // TODO prendre le user id dans les shared pref
                /*(get() as SharedPref).getStringValue(SharedPref.USER_ID).takeIf { it.isNotEmpty() }
                    ?.let { userId ->
                        requestBuilder.header("user-id", userId)
                    }*/
                requestBuilder.header("user-id", "1")
                return@addInterceptor interceptor.proceed(requestBuilder.build())
            }

        if (BuildConfig.DEBUG) {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logInterceptor)
        }

        return@single okHttpClientBuilder.build()
    }

    single {
        return@single Retrofit.Builder()
            .baseUrl("https://polochon-dev.herokuapp.com/")
            .client(get() as OkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PollService::class.java)
    }
}