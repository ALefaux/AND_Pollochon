package fr.alefaux.pollochon.core.data.repository.user

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User
import fr.alefaux.pollochon.core.network.UserNetworkDataSource

class UserRepositoryImpl(
    private val settingsRepository: SettingsRepository,
    private val userNetworkDataSource: UserNetworkDataSource
) : UserRepository {
    override suspend fun checkUserExists(firebaseId: String): DataResponse<User> {
        return userNetworkDataSource.checkUserExists(firebaseId).also { response ->
            if (response is DataResponse.Found) {
                settingsRepository.setUserId(response.data.id)
                settingsRepository.setUserName(response.data.userName)
            }
        }
    }

    override suspend fun registerUserName(
        firebaseId: String,
        userName: String
    ): DataResponse<User> {
        return userNetworkDataSource.createUser(firebaseId, userName).also { response ->
            if (response is DataResponse.Found) {
                settingsRepository.setUserId(response.data.id)
                settingsRepository.setUserName(response.data.userName)
            } else if (response is DataResponse.Success) {
                settingsRepository.setUserId(response.data.id)
                settingsRepository.setUserName(response.data.userName)
            }
        }
    }

    override suspend fun getFriendsByUserId(userId: Int): DataResponse<List<User>> {
        return userNetworkDataSource.getFriendsByUserId(userId)
    }
}
