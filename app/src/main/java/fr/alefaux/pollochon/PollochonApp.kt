package fr.alefaux.pollochon

import android.app.Application
import fr.alefaux.pollochon.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class PollochonApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PollochonApp)
            modules(
                listOf(
                    busModule,
                    appModule,
                    useCaseModule,
                    repositoryModule,
                    networkModule,
                    serviceModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}