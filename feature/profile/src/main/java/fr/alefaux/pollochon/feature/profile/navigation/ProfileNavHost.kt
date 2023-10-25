package fr.alefaux.pollochon.feature.profile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.alefaux.pollochon.feature.profile.ProfileScreen

@Composable
fun ProfileNavHost(
    modifier: Modifier = Modifier
) = NavHost(
    modifier = modifier,
    navController = rememberNavController(),
    startDestination = ProfileDestination.root
) {
    composable(ProfileDestination.root) {
        ProfileScreen()
    }
}