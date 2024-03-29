package fr.alefaux.pollochon.core.model.survey

data class HomeSurveys(
    val ownSurveys: List<Survey>,
    val participatedSurveys: List<Survey>,
    val invitedSurveys: List<Survey>
) {
    fun isEmpty(): Boolean {
        return ownSurveys.isEmpty() && participatedSurveys.isEmpty() && invitedSurveys.isEmpty()
    }
}
