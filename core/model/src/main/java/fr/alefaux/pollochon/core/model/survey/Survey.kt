package fr.alefaux.pollochon.core.model.survey

import fr.alefaux.pollochon.core.model.user.User

data class Survey(
    val id: Int,
    val title: String,
    val type: SurveyType,
    val createdAt: String,
    val owner: User,
    val answers: List<SurveyResponse>,
    val invitations: List<SurveyInvitation>
)
