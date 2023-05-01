package fr.alefaux.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.SetIsConnectedUseCase
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCase
import fr.alefaux.pollochon.core.domain.login.RegisterUserNameUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val setIsConnectedUseCase: SetIsConnectedUseCase,
    private val checkUserExistsUseCase: CheckUserExistsUseCase,
    private val registerUserNameUseCase: RegisterUserNameUseCase
) : ViewModel() {

    private val _noUserNameFlow = MutableSharedFlow<Unit>()
    val noUserNameFlow: SharedFlow<Unit> = _noUserNameFlow
    private val _pseudoErrorFlow = MutableSharedFlow<Boolean>()
    val pseudoErrorFlow: SharedFlow<Boolean> = _pseudoErrorFlow
    private val _createUserErrorFlow = MutableSharedFlow<Boolean>()
    val createUserErrorFlow: SharedFlow<Boolean> = _createUserErrorFlow

    fun onUserSuccessToLogin(firebaseId: String) {
        viewModelScope.launch {
            val result = checkUserExistsUseCase.invoke(firebaseId)
            when (result) {
                is DataResponse.Found -> setIsConnectedUseCase.setUserIsConnected(true)
                DataResponse.NotFound -> _noUserNameFlow.emit(Unit)
                else -> {}
            }
        }
    }

    fun registerUserName(username: String) {
        viewModelScope.launch {
            when (registerUserNameUseCase.invoke(username)) {
                DataResponse.Created -> setIsConnectedUseCase.setUserIsConnected(true)
                DataResponse.BadRequest -> _createUserErrorFlow.emit(true)
                DataResponse.Conflict -> _pseudoErrorFlow.emit(true)
                else -> {}
            }
        }
    }
}
