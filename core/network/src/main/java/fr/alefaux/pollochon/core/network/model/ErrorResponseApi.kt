package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.ErrorResponse
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseApi(
    val message: String
) {
    fun toDomain(): ErrorResponse {
        return ErrorResponse(
            message = message
        )
    }
}
