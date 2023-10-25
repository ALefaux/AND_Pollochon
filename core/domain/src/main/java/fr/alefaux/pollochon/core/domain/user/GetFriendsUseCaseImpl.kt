package fr.alefaux.pollochon.core.domain.user

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.user.UserRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetFriendsUseCaseImpl(
    private val userRepository: UserRepository,
    private val settingsRepository: SettingsRepository
): GetFriendsUseCase {
    override suspend fun invoke(): Flow<DataResponse<List<User>>> {
        return settingsRepository.getUserId().map {  userId ->
            userRepository.getFriendsByUserId(userId)
        }
    }
}