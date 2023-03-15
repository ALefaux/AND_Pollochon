package fr.alefaux.pollochon.core.data.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun userIsConnected(): Flow<Boolean>
    suspend fun setUserIsConnected(isConnected: Boolean)
}
