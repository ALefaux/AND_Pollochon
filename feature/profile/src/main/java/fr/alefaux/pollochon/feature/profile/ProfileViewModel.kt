package fr.alefaux.pollochon.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.LogoutUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            logoutUseCase.logout()
        }
    }
}
