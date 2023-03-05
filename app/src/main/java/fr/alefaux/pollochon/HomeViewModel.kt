package fr.alefaux.pollochon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Splash)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _uiState.value = HomeUiState.Home
        }
    }
}

sealed class HomeUiState {
    object Splash: HomeUiState()
    object Login: HomeUiState()
    object Home: HomeUiState()
}