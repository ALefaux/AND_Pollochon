package fr.alefaux.pollochon.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.domain.LogoutUseCase
import fr.alefaux.pollochon.core.domain.user.GetFriendsUseCase
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.feature.profile.model.FriendsState
import fr.alefaux.pollochon.feature.profile.model.ProfileState
import fr.alefaux.pollochon.feature.profile.model.ProfileUi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class ProfileViewModel(
    private val logoutUseCase: LogoutUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val getFriendsUseCase: GetFriendsUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _uiState: MutableStateFlow<ProfileState> = MutableStateFlow(ProfileState.Loading)
    val uiState: StateFlow<ProfileState> = _uiState

    private val _friends: MutableStateFlow<FriendsState> = MutableStateFlow(FriendsState.Idle)
    val friends: StateFlow<FriendsState> = _friends

    init {
        viewModelScope.launch(ioDispatcher) {
            getUserUseCase.getUser().collect { user ->
                _uiState.value = ProfileState.Loaded(ProfileUi(user.userName, user.userImageUrl))
                loadFriends()
            }
        }
    }

    fun logout() {
        viewModelScope.launch(ioDispatcher) {
            logoutUseCase.logout()
        }
    }

    private suspend fun loadFriends() {
        _friends.emit(FriendsState.Loading)
        getFriendsUseCase().collect { response ->
            when (response) {
                is DataResponse.Success -> {
                    if (response.data.isEmpty()) {
                        _friends.emit(FriendsState.Empty)
                    } else {
                        _friends.emit(FriendsState.Loaded(response.data))
                    }
                }

                else -> {
                    Timber.d("Couldn't load friends")
                    _friends.emit(FriendsState.Idle)
                }
            }
        }
    }
}
