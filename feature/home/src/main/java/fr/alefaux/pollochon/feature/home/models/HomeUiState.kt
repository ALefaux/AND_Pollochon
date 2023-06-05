package fr.alefaux.pollochon.feature.home.models

import fr.alefaux.pollochon.core.model.survey.HomeSurveys

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Loaded(val homeSurveys: HomeSurveys) : HomeUiState()
    object Error : HomeUiState()
    object Empty : HomeUiState()
}
