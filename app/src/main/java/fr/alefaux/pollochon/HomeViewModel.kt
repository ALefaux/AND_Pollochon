package fr.alefaux.pollochon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        runBlocking {
            var newState: HomeUiState = HomeUiState.Loading
            val tasks = listOf(
                async(Dispatchers.IO) { delay(3000) },
                async(Dispatchers.IO) {
                    newState = if (Firebase.auth.currentUser != null) {
                        HomeUiState.Home
                    } else {
                        HomeUiState.Login
                    }
                }
            )
            tasks.awaitAll()
            _uiState.value = newState
        }
    }

    fun listenUserIdConnected() {
        viewModelScope.launch {
            settingsRepository.userIsConnected().collect { isConnected ->
                _uiState.value = if (isConnected) {
                    HomeUiState.Home
                } else {
                    HomeUiState.Login
                }
            }
        }
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    object Login : HomeUiState()
    object Home : HomeUiState()
}
