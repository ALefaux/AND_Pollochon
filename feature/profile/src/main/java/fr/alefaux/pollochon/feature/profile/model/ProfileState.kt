package fr.alefaux.pollochon.feature.profile.model

sealed class ProfileState {
    object Loading : ProfileState()
    class Loaded(val profileUi: ProfileUi) : ProfileState()
    object Error : ProfileState()
}
