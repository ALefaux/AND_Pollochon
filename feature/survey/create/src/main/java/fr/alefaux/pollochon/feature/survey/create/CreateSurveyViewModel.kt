package fr.alefaux.pollochon.feature.survey.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.poll.CreatePollUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.feature.survey.create.models.ChoiceType
import fr.alefaux.pollochon.feature.survey.create.models.CreateResultState
import fr.alefaux.pollochon.feature.survey.create.models.CreateSurveyUi
import fr.alefaux.pollochon.feature.survey.create.models.CreateSurveyUiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Date

class CreateSurveyViewModel(
    private val createPollUseCase: CreatePollUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CreateSurveyUiState>(
        CreateSurveyUiState.PrincipalInfo(
            CreateSurveyUi("", null, null)
        )
    )
    val uiState: StateFlow<CreateSurveyUiState> = _uiState

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _createResultState: MutableStateFlow<CreateResultState> =
        MutableStateFlow(CreateResultState.None)
    val createResultState: StateFlow<CreateResultState> = _createResultState

    private lateinit var title: String
    private lateinit var type: SurveyType
    private var endDate: Date? = null
    private var proposals: List<String> = listOf()

    fun createSurvey(proposals: List<String>) {
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

    fun nextPage(title: String, type: SurveyType, endDate: Date?) {
        this.title = title
        this.type = type
        this.endDate = endDate

        viewModelScope.launch(dispatcher) {
            _uiState.emit(CreateSurveyUiState.Proposals(proposals))
        }
    }

    fun previousPage(proposals: List<String>) {
        this.proposals = proposals

        viewModelScope.launch(dispatcher) {
            _uiState.emit(
                CreateSurveyUiState.PrincipalInfo(
                    CreateSurveyUi(title, type, endDate)
                )
            )
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
