package fr.alefaux.pollochon.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import fr.alefaux.pollochon.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : Screen("home", R.string.screen_home_name, R.drawable.ic_home)
    object CreateSurvey : Screen("survey/create", R.string.screen_create_survey, R.drawable.ic_add)
}
