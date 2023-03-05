package fr.alefaux.pollochon

import android.app.Application
import fr.alefaux.pollochon.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PollochonApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PollochonApp)
            modules(listOf(appModule))
        }
    }
}
