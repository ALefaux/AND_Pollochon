package fr.alefaux.pollochon.feature.survey.create.models

sealed interface CreateSurveyUiState {
    data class PrincipalInfo(val createSurveyUi: CreateSurveyUi): CreateSurveyUiState
    data class Proposals(val proposals: List<String>): CreateSurveyUiState
}
