package fr.alefaux.pollochon.core.domain

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.model.user.User
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(
    private val settingsRepository: SettingsRepository
) {
    fun getUser(): Flow<User> {
        return settingsRepository.getUser()
    }
}
