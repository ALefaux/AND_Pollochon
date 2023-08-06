package fr.alefaux.pollochon.feature.survey.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.poll.CreatePollUseCase
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class CreateSurveyViewModel(
    private val createPollUseCase: CreatePollUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState.asStateFlow()

    private val _titleState: MutableStateFlow<TextFieldState> =
        MutableStateFlow(TextFieldState.None)
    val titleState: StateFlow<TextFieldState> = _titleState.asStateFlow()

    private val _createResultState: MutableStateFlow<CreateResultState> =
        MutableStateFlow(CreateResultState.None)
    val createResultState: StateFlow<CreateResultState> = _createResultState.asStateFlow()

    fun createSurvey(title: String, type: SurveyType) {
        viewModelScope.launch(dispatcher) {
            _loadingState.emit(true)
            createPollUseCase(title, type)
                .catch {
                    Timber.d(it)
                    _loadingState.emit(false)
                    _createResultState.emit(CreateResultState.Error)
                }.collect {
                    _loadingState.emit(false)
                    _createResultState.emit(CreateResultState.Success)
                }
        }
    }

    fun validateTitle(title: String) {
        _titleState.value = if (title.isEmpty()) {
            TextFieldState.None
        } else if (title.length in 10..100) {
            TextFieldState.Success
        } else {
            TextFieldState.Error
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

sealed class CreateResultState {
    data object None: CreateResultState()
    data object Error: CreateResultState()
    data object Success: CreateResultState()
}
