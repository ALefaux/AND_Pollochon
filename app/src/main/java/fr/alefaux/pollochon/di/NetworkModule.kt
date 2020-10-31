package fr.alefaux.pollochon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import fr.alefaux.pollochon.network.PollService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
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
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://polochon-dev.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePollService(retrofit: Retrofit): PollService {
        return retrofit.create(PollService::class.java)
    }
}