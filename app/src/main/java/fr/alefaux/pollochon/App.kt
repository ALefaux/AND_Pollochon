package fr.alefaux.pollochon

import android.app.Application
import fr.alefaux.pollochon.di.busModule
import fr.alefaux.pollochon.di.splashscreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    busModule,
                    splashscreenModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}