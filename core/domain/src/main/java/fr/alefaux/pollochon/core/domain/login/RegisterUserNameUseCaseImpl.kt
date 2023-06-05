package fr.alefaux.pollochon.core.domain.login

import com.google.firebase.auth.FirebaseAuth
import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

class RegisterUserNameUseCaseImpl(
    private val loginRepository: LoginRepository,
    private val settingsRepository: SettingsRepository
) : RegisterUserNameUseCase {
    override suspend fun invoke(username: String): DataResponse<User> {
        val firebaseId: String =
            FirebaseAuth.getInstance().currentUser?.uid ?: throw Exception("User not connected")
        return loginRepository.registerUserName(firebaseId, username)
    }
}
