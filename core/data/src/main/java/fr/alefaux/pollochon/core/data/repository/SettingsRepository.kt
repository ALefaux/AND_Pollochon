package fr.alefaux.pollochon.core.data.repository

import fr.alefaux.pollochon.core.model.user.User
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun userIsConnected(): Flow<Boolean>
    suspend fun setUserIsConnected(isConnected: Boolean)

    fun getUserId(): Flow<Int>
    fun getUser(): Flow<User>
    suspend fun setUserId(userId: Int)
    suspend fun setUserName(userName: String)
}
