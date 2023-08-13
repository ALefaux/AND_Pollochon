package fr.alefaux.pollochon.feature.home.models

data class HomeSurveysUi(
    val invited: SurveyUi?,
    val participated: SurveyUi?,
    val own: SurveyUi?,
)
