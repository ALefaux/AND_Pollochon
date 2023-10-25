package fr.alefaux.pollochon.core.domain.user

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User
import kotlinx.coroutines.flow.Flow

interface GetFriendsUseCase {
    suspend operator fun invoke(): Flow<DataResponse<List<User>>>
}