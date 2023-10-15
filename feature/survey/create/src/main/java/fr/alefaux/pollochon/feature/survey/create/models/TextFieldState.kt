package fr.alefaux.pollochon.feature.survey.create.models

sealed class TextFieldState {
    data object None : TextFieldState()
    data object Error : TextFieldState()
    data object Success : TextFieldState()
}