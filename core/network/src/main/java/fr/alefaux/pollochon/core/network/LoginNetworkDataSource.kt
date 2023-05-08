package fr.alefaux.pollochon.core.network

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.user.User

interface LoginNetworkDataSource {
    suspend fun checkUserExists(firebaseId: String): DataResponse<User>
    suspend fun createUser(firebaseId: String, pseudo: String): DataResponse<Nothing>
}
