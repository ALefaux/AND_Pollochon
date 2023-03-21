package fr.alefaux.pollochon.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.domain.LogoutUseCase
import fr.alefaux.pollochon.feature.profile.model.ProfileState
import fr.alefaux.pollochon.feature.profile.model.ProfileUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val logoutUseCase: LogoutUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<ProfileState> = MutableStateFlow(ProfileState.Loading)
    val uiState: StateFlow<ProfileState> = _uiState

    init {
        viewModelScope.launch {
            getUserUseCase.getUser().collect {
                _uiState.value = ProfileState.Loaded(ProfileUi(it.userName, it.userImageUrl))
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            logoutUseCase.logout()
        }
    }
}
