package fr.alefaux.pollochon.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import fr.alefaux.pollochon.core.model.survey.Survey
import fr.alefaux.pollochon.feature.home.mapper.toUi
import fr.alefaux.pollochon.feature.home.models.HomeSurveysUi
import fr.alefaux.pollochon.feature.home.models.HomeUiState
import fr.alefaux.pollochon.feature.home.models.SurveyUi
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
                                _homeUiState.emit(HomeUiState.Loaded(createHomeSurveysUi(homeSurveys.data)))
                            }
                        }

                        else -> {
                            _homeUiState.emit(HomeUiState.Error)
                        }
                    }
                }
        }
    }

    private fun createHomeSurveysUi(homeSurveys: HomeSurveys): HomeSurveysUi {
        val lastInvited = findLastSurvey(homeSurveys.invitedSurveys)
        val lastOwned = findLastSurvey(homeSurveys.ownSurveys)
        val lastParticipated = findLastSurvey(homeSurveys.participatedSurveys)

        return HomeSurveysUi(
            invited = lastInvited,
            own = lastOwned,
            participated = lastParticipated
        )
    }

    private fun findLastSurvey(surveys: List<Survey>): SurveyUi? {
        return surveys.maxByOrNull { it.id }?.toUi()
    }
}
