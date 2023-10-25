package fr.alefaux.pollochon.core.domain.login

import fr.alefaux.pollochon.core.data.repository.user.UserRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

class CheckUserExistsUseCaseImpl(
    private val loginRepository: UserRepository
) : CheckUserExistsUseCase {
    override suspend fun invoke(firebaseId: String): DataResponse<User> {
        return loginRepository.checkUserExists(firebaseId)
    }
}
