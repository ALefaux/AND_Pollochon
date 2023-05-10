package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

interface RegisterUserNameUseCase {
    suspend fun invoke(username: String): DataResponse<User>
}
