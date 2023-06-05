package fr.alefaux.pollochon.core.model.survey

import fr.alefaux.pollochon.core.model.user.User

data class SurveyInvitation(
    val id: Int,
    val createAt: String,
    val acceptedAt: String?,
    val invited: User
)
