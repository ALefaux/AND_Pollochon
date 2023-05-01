package fr.alefaux.pollochon.core.domain.login

import com.google.firebase.auth.FirebaseAuth
import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.model.DataResponse

class RegisterUserNameUseCaseImpl(
    private val loginRepository: LoginRepository,
    private val settingsRepository: SettingsRepository
) : RegisterUserNameUseCase {
    override suspend fun invoke(username: String): DataResponse<Nothing> {
        val firebaseId: String =
            FirebaseAuth.getInstance().currentUser?.uid ?: throw Exception("User not connected")
        return loginRepository.registerUserName(firebaseId, username).also {
            if (it.isSuccess()) {
                settingsRepository.setUserName(username)
            }
        }
    }
}
