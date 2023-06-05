package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.survey.SurveyInvitation
import kotlinx.serialization.Serializable

@Serializable
data class SurveyInvitationApi(
    val id: Int,
    val createAt: String,
    val acceptedAt: String?,
    val invited: UserApi
) {
    fun toSurveyInvitation(): SurveyInvitation {
        return SurveyInvitation(
            id = id,
            createAt = createAt,
            acceptedAt = acceptedAt,
            invited = invited.toUser()
        )
    }
}
