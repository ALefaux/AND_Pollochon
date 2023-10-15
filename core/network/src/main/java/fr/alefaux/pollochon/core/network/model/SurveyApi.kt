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
    val endDate: String?,
    val owner: UserApi,
    val invitations: List<SurveyInvitationApi>,
    val proposals: List<ProposalApi>
) {
    fun toSurvey(): Survey {
        return Survey(
            id = id,
            title = title,
            type = type,
            createdAt = createdAt,
            owner = owner.toUser(),
            invitations = invitations.map { it.toSurveyInvitation() }
        )
    }
}
