package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.user.User
import kotlinx.serialization.Serializable

@Serializable
data class UserApi(
    val id: Int,
    val pseudo: String
) {
    fun toUser(): User {
        return User(
            userName = pseudo,
            userImageUrl = null
        )
    }
}
