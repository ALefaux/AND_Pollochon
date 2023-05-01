package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.User

interface CheckUserExistsUseCase {
    suspend fun invoke(firebaseId: String): DataResponse<User>
}
