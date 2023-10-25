package fr.alefaux.pollochon.feature.profile.model

import fr.alefaux.pollochon.core.model.user.User

sealed interface FriendsState {
    data object Idle: FriendsState
    data object Loading: FriendsState
    data class Loaded(val friends: List<User>): FriendsState
    data object Empty: FriendsState
}