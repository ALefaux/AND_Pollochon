package fr.alefaux.pollochon.core.data.repository.login

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.User

interface LoginRepository {
    suspend fun checkUserExists(firebaseId: String): DataResponse<User>
    suspend fun registerUserName(firebaseId: String, userName: String): DataResponse<Nothing>
}
