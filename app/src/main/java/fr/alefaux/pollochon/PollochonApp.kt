package fr.alefaux.pollochon

import android.app.Application
import fr.alefaux.login.di.loginModule
import fr.alefaux.pollochon.core.data.di.dataModule
import fr.alefaux.pollochon.core.datastore.di.dataStoreModule
import fr.alefaux.pollochon.core.domain.di.domainModule
import fr.alefaux.pollochon.core.network.di.networkModule
import fr.alefaux.pollochon.di.appModule
import fr.alefaux.pollochon.feature.home.di.featureHomeModule
import fr.alefaux.pollochon.feature.profile.di.profileModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class PollochonApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PollochonApp)
            modules(
                listOf(
                    appModule,

                    // Feature
                    loginModule,
                    featureHomeModule,
                    profileModule,

                    // Core
                    domainModule,
                    dataModule,
                    dataStoreModule,
                    networkModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
