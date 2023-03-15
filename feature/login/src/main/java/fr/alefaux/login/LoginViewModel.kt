package fr.alefaux.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.SetIsConnectedUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val setIsConnectedUseCase: SetIsConnectedUseCase
) : ViewModel() {

    fun setUserConnected() {
        viewModelScope.launch {
            setIsConnectedUseCase.setUserIsConnected(true)
        }
    }
}
