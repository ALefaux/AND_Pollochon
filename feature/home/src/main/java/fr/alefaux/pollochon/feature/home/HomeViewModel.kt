package fr.alefaux.pollochon.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.feature.home.models.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeSurveysUseCase: GetHomeSurveysUseCase
) : ViewModel() {

    private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    fun fetchHomeSurveys() {
        viewModelScope.launch {
            _homeUiState.emit(HomeUiState.Loading)
            getHomeSurveysUseCase.invoke()
                .collect { homeSurveys ->
                    when (homeSurveys) {
                        is DataResponse.Success -> {
                            if (homeSurveys.data.isEmpty()) {
                                _homeUiState.emit(HomeUiState.Empty)
                            } else {
                                _homeUiState.emit(HomeUiState.Loaded(homeSurveys.data))
                            }
                        }

                        else -> {
                            _homeUiState.emit(HomeUiState.Error)
                        }
                    }
                }
        }
    }
}
