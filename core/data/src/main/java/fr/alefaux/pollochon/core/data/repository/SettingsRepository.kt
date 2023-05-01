package fr.alefaux.pollochon.core.data.repository

import fr.alefaux.pollochon.core.model.User
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun userIsConnected(): Flow<Boolean>
    suspend fun setUserIsConnected(isConnected: Boolean)

    fun getUser(): Flow<User>
    suspend fun setUserName(userName: String)
}
