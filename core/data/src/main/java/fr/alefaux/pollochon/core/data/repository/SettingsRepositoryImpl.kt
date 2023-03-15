package fr.alefaux.pollochon.core.data.repository

import fr.alefaux.pollochon.core.datastore.SettingsDataStore
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val settingsDataStore: SettingsDataStore
): SettingsRepository {
    override fun userIsConnected(): Flow<Boolean> {
        return settingsDataStore.userIsLogged()
    }

    override suspend fun setUserIsConnected(isConnected: Boolean) {
        settingsDataStore.setUserIsLogged(isConnected)
    }
}