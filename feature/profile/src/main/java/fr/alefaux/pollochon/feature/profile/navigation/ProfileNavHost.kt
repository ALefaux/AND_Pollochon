package fr.alefaux.pollochon.feature.profile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.alefaux.pollochon.feature.profile.screen.friends.FriendsScreen
import fr.alefaux.pollochon.feature.profile.screen.profile.ProfileScreen

@Composable
fun ProfileNavHost(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = ProfileDestination.root
    ) {
        composable(ProfileDestination.root) {
            ProfileScreen(
                onSeeAllFriendsScreen = {
                    navHostController.navigate(ProfileDestination.Friends.route)
                }
            )
        }
        composable(ProfileDestination.Friends.route) {
            FriendsScreen()
        }
    }
}