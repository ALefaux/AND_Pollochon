package fr.alefaux.pollochon.core.datastore.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import fr.alefaux.pollochon.core.datastore.SettingsDataStore
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import java.io.File

val dataStoreModule = module {
    single {
        PreferenceDataStoreFactory.create(
            produceFile = { File("settings.preferences_pb") }
        )
    }

    factoryOf(::SettingsDataStore)
}
