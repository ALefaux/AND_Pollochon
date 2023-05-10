package fr.alefaux.pollochon.core.data.repository

import fr.alefaux.pollochon.core.datastore.SettingsDataStore
import fr.alefaux.pollochon.core.model.user.User
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

    override fun getUserId(): Flow<Int> {
        return settingsDataStore.getUserId()
    }

    override fun getUser(): Flow<User> {
        return settingsDataStore.getUserId()
            .zip(settingsDataStore.getUserName()) { userId, userName ->
                Pair(userId, userName)
            }
            .zip(settingsDataStore.getUserImageUrl()) { idAndPseudo, userImageUrl ->
                User(idAndPseudo.first, idAndPseudo.second, userImageUrl)
            }
    }

    override suspend fun setUserId(userId: Int) {
        settingsDataStore.setUserId(userId)
    }

    override suspend fun setUserName(userName: String) {
        settingsDataStore.setUserName(userName)
    }
}
