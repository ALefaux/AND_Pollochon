package fr.alefaux.pollochon.feature.survey.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.poll.CreatePollUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Date

class CreateSurveyViewModel(
    private val createPollUseCase: CreatePollUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState


    private val _createResultState: MutableStateFlow<CreateResultState> =
        MutableStateFlow(CreateResultState.None)
    val createResultState: StateFlow<CreateResultState> = _createResultState

    private val _indexPage = MutableStateFlow(0)
    val indexPage: StateFlow<Int> = _indexPage

    fun createSurvey(title: String, type: SurveyType, endDate: Date?, proposals: List<String>) {
        viewModelScope.launch(dispatcher) {
            _loadingState.emit(true)
            createPollUseCase(title, type, endDate, proposals)
                .catch {
                    Timber.d(it)
                    _loadingState.emit(false)
                    _createResultState.emit(CreateResultState.Error.Unknown(it.localizedMessage))
                }.collect { response ->
                    _loadingState.emit(false)

                    when (response) {
                        is DataResponse.BadRequest ->
                            _createResultState.emit(CreateResultState.Error.BadRequest)
                        is DataResponse.NotFound ->
                            _createResultState.emit(CreateResultState.Error.UserNotFound)
                        else -> _createResultState.emit(CreateResultState.Success)
                    }
                }
        }
    }

    fun nextPage() {
        viewModelScope.launch(dispatcher) {
            _indexPage.value += 1
        }
    }

    fun previousPage() {
        viewModelScope.launch(dispatcher) {
            _indexPage.value -= 1
        }
    }

    companion object {
        val typeItems = listOf(
            ChoiceType("1", "Choix unique", SurveyType.SIMPLE),
            ChoiceType("N", "Choix multiple", SurveyType.MULTIPLE),
            ChoiceType("nNn", "Choix pondéré", SurveyType.DISTRIBUTION),
        )
    }
}

data class ChoiceType(
    val icon: String,
    val title: String,
    val type: SurveyType,
)

sealed class TextFieldState {
    data object None : TextFieldState()
    data object Error : TextFieldState()
    data object Success : TextFieldState()
}

sealed interface CreateResultState {
    data object None : CreateResultState
    sealed interface Error : CreateResultState {
        data object BadRequest : Error
        data object UserNotFound : Error
        data class Unknown(val message: String?) : Error
    }

    data object Success : CreateResultState
}
