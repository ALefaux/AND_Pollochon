package fr.alefaux.pollochon.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import fr.alefaux.pollochon.R

sealed class Screen(
    val route: String,
)

sealed class BottomNavScreen(
    route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
): Screen(route) {
    data object Home : BottomNavScreen("home", R.string.screen_home_name, R.drawable.ic_home)
    data object CreateSurvey : BottomNavScreen("survey/create", R.string.screen_create_survey, R.drawable.ic_add)
}

sealed class Screens(
    route: String
): Screen(route) {
    data object Profile: Screens("profile")
}
