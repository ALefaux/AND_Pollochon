package fr.alefaux.pollochon.core.domain

import com.google.firebase.auth.FirebaseAuth
import fr.alefaux.pollochon.core.data.repository.SettingsRepository

class LogoutUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend fun logout() {
        FirebaseAuth.getInstance().signOut()
        settingsRepository.setUserIsConnected(false)
    }
}
