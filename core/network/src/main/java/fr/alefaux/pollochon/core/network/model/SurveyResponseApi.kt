package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.survey.SurveyResponse
import kotlinx.serialization.Serializable

@Serializable
data class SurveyResponseApi(
    val id: Int,
    val note: Int,
    val createAt: String,
    val owner: UserApi
) {
    fun toSurveyResponse(): SurveyResponse {
        return SurveyResponse(
            id = id,
            note = note,
            createAt = createAt,
            owner = owner.toUser()
        )
    }
}
