package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.serialization.Serializable

@Serializable
data class CreateSurveyApi(
    val title: String,
    val type: SurveyType,
    val ownerId: Int,
    val endDate: String?,
    val proposals: List<String>
)
