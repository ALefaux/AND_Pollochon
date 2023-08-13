package fr.alefaux.pollochon.feature.home.models

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Loaded(val homeSurveys: HomeSurveysUi) : HomeUiState()
    data object Error : HomeUiState()
    data object Empty : HomeUiState()
}
