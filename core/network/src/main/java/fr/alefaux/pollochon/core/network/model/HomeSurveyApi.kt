package fr.alefaux.pollochon.core.network.model

import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import kotlinx.serialization.Serializable

@Serializable
data class HomeSurveyApi(
    val ownSurveys: List<SurveyApi>,
    val participatedSurveys: List<SurveyApi>,
    val invitedSurveys: List<SurveyApi>
) {
    fun toHomeSurvey(): HomeSurveys {
        return HomeSurveys(
            ownSurveys = ownSurveys.map { it.toSurvey() },
            participatedSurveys = participatedSurveys.map { it.toSurvey() },
            invitedSurveys = invitedSurveys.map { it.toSurvey() }
        )
    }
}
