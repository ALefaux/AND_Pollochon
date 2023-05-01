package fr.alefaux.pollochon.core.data.repository

import fr.alefaux.pollochon.core.datastore.SettingsDataStore
import fr.alefaux.pollochon.core.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

class SettingsRepositoryImpl(
    private val settingsDataStore: SettingsDataStore
) : SettingsRepository {
    override fun userIsConnected(): Flow<Boolean> {
        return settingsDataStore.userIsLogged()
    }

    override suspend fun setUserIsConnected(isConnected: Boolean) {
        settingsDataStore.setUserIsLogged(isConnected)
    }

    override fun getUser(): Flow<User> {
        return settingsDataStore.getUserName()
            .zip(settingsDataStore.getUserImageUrl()) { userName, userImageUrl ->
                User(userName, userImageUrl)
            }
    }

    override suspend fun setUserName(userName: String) {
        settingsDataStore.setUserName(userName)
    }
}
