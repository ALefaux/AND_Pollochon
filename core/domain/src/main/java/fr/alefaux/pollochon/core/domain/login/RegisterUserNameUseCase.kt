package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.model.DataResponse

interface RegisterUserNameUseCase {
    suspend fun invoke(username: String): DataResponse<Nothing>
}
