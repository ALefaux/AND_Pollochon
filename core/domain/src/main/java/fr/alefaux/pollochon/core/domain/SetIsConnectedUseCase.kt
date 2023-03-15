package fr.alefaux.pollochon.core.domain

import fr.alefaux.pollochon.core.data.repository.SettingsRepository

class SetIsConnectedUseCase(
    private val settingsRepository: SettingsRepository
) {

    suspend fun setUserIsConnected(isConnected: Boolean) {
        settingsRepository.setUserIsConnected(isConnected)
    }
}