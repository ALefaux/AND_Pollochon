package fr.alefaux.pollochon.core.model.survey

import fr.alefaux.pollochon.core.model.user.User

data class SurveyResponse(
    val id: Int,
    val note: Int,
    val createAt: String,
    val owner: User
)
