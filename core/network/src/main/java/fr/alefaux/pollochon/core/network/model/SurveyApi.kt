package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.core.model.survey.Survey
import kotlinx.serialization.Serializable

@Serializable
data class SurveyApi(
    val id: Int,
    val title: String,
    val type: SurveyType,
    val createdAt: String,
    val owner: UserApi,
    val answers: List<SurveyResponseApi>,
    val invitations: List<SurveyInvitationApi>
) {
    fun toSurvey(): Survey {
        return Survey(
            id = id,
            title = title,
            type = type,
            createdAt = createdAt,
            owner = owner.toUser(),
            answers = answers.map { it.toSurveyResponse() },
            invitations = invitations.map { it.toSurveyInvitation() }
        )
    }
}
