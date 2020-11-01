package fr.alefaux.pollochon.views.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import dagger.hilt.android.AndroidEntryPoint
import fr.alefaux.pollochon.views.Screen
import fr.alefaux.pollochon.views.listpolls.ListPolls
import fr.alefaux.pollochon.views.listpolls.ListPollsViewModel

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val listPollsViewModel: ListPollsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeActivityNavigation(listPollsViewModel)
        }
    }

}

@Composable
fun HomeActivityNavigation(listPollsViewModel: ListPollsViewModel) {
    listPollsViewModel.getAll()
    val items = listOf(
        Screen.ListPolls
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            // This is the equivalent to popUpTo the start destination
                            navController.popBackStack(navController.graph.startDestination, false)

                            // This if check gives us a "singleTop" behavior where we do not create a
                            // second instance of the composable if we are already on that destination
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Screen.ListPolls.route) {
            composable(Screen.ListPolls.route) { ListPolls(listPollsViewModel) }
        }
    }
}