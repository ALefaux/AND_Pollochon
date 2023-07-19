package fr.alefaux.pollochon.feature.survey.create

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateSurveyViewModel : ViewModel() {

    private var _uiState = mutableStateOf(CreateSurveyUiState.Loaded)
    val uiState get(): State<CreateSurveyUiState> = _uiState
}

sealed class CreateSurveyUiState {
    object Loaded : CreateSurveyUiState()
}
