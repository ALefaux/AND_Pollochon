package fr.alefaux.pollochon.core.model.survey

data class HomeSurvey(
    val ownSurveys: List<Survey>,
    val participatedSurveys: List<Survey>,
    val invitedSurveys: List<Survey>
)
