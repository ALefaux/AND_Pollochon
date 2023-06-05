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
    private val _pseudoErrorFlow = MutableSharedFlow<String>()
    val pseudoErrorFlow: SharedFlow<String> = _pseudoErrorFlow
    private val _createUserErrorFlow = MutableSharedFlow<Boolean>()
    val createUserErrorFlow: SharedFlow<Boolean> = _createUserErrorFlow
    private val _creatingUserNameFlow = MutableSharedFlow<Boolean>()
    val creatingUserNameFlow: SharedFlow<Boolean> = _creatingUserNameFlow

    fun onUserSuccessToLogin(firebaseId: String) {
        viewModelScope.launch {
            when (checkUserExistsUseCase.invoke(firebaseId)) {
                is DataResponse.Found -> setUserIsConnected()
                DataResponse.NotFound -> _noUserNameFlow.emit(Unit)
                else -> {}
            }
        }
    }

    fun registerUserName(username: String) {
        viewModelScope.launch {
            if (username.isEmpty()) {
                _pseudoErrorFlow.emit("Le pseudo ne peut pas être vide")
                return@launch
            }

            _creatingUserNameFlow.emit(true)
            _pseudoErrorFlow.emit("")

            when (registerUserNameUseCase.invoke(username)) {
                is DataResponse.Success -> {
                    _creatingUserNameFlow.emit(false)
                    setUserIsConnected()
                }

                DataResponse.BadRequest -> {
                    _creatingUserNameFlow.emit(false)
                    _createUserErrorFlow.emit(true)
                }

                DataResponse.Conflict -> {
                    _creatingUserNameFlow.emit(false)
                    _pseudoErrorFlow.emit("Le pseudo est déjà utilisé")
                }

                else -> {
                    _creatingUserNameFlow.emit(false)
                }
            }
        }
    }

    private suspend fun setUserIsConnected() {
        setIsConnectedUseCase.setUserIsConnected(true)
    }
}
