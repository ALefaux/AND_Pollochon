package fr.alefaux.pollochon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.domain.hello.SayHelloUseCase
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeViewModel(
    private val settingsRepository: SettingsRepository,
    private val sayHelloUseCase: SayHelloUseCase,
    private val checkUserExistsUseCase: CheckUserExistsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        runBlocking {
            var newState: HomeUiState = HomeUiState.Loading
            val tasks = listOf(
                async(Dispatchers.IO) { delay(3000) },
                async(Dispatchers.IO) {
                    newState = if (checkUserIsLogged()) {
                        HomeUiState.Logged
                    } else {
                        HomeUiState.Login
                    }
                },
                async(Dispatchers.IO) {
                    if (sayHelloUseCase.invoke() == DataResponse.Error) {
                        newState = HomeUiState.Error("Une erreur est survenue lors du reveil du server")
                    }
                }
            )
            tasks.awaitAll()
            _uiState.value = newState
        }
    }

    private suspend fun checkUserIsLogged(): Boolean {
        val currentUser = Firebase.auth.currentUser
        return currentUser != null
                && settingsRepository.containsUserIsLogged().first()
                && (checkUserExistsUseCase(currentUser.uid) is DataResponse.Found)
    }

    fun listenUserIdConnected() {
        viewModelScope.launch {
            settingsRepository.userIsConnected().collect { isConnected ->
                _uiState.value = if (isConnected) {
                    HomeUiState.Logged
                } else {
                    HomeUiState.Login
                }
            }
        }
    }
}

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data object Login : HomeUiState
    data object Logged : HomeUiState
    data class Error(val message: String) : HomeUiState
}
