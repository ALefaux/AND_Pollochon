package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

interface CheckUserExistsUseCase {
    suspend operator fun invoke(firebaseId: String): DataResponse<User>
}
