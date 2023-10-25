package fr.alefaux.pollochon.core.data.repository.user

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

interface UserRepository {
    suspend fun checkUserExists(firebaseId: String): DataResponse<User>
    suspend fun registerUserName(firebaseId: String, userName: String): DataResponse<User>
    suspend fun getFriendsByUserId(userId: Int): DataResponse<List<User>>
}
