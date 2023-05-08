package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

class CheckUserExistsUseCaseImpl(
    private val loginRepository: LoginRepository
) : CheckUserExistsUseCase {
    override suspend fun invoke(firebaseId: String): DataResponse<User> {
        return loginRepository.checkUserExists(firebaseId)
    }
}
