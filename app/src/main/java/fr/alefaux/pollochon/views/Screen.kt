package fr.alefaux.pollochon.views

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.pollochon.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object ListPolls : Screen("listpolls", R.string.screen_list_polls_name, Icons.Filled.List)
    object Profile : Screen("profile", R.string.screen_profile_name, Icons.Filled.Person)
}
