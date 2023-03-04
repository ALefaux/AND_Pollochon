package fr.alefaux.pollochon.views.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import fr.alefaux.pollochon.views.Screen

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeActivityNavigation()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivityNavigation() {
    val items = listOf(
        Screen.ListPolls
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                //val navBackStackEntry by navController.currentBackStackEntryAsState()
                //val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = false,
                        onClick = {
                            // This is the equivalent to popUpTo the start destination
                            navController.popBackStack(
                                navController.graph.startDestinationId,
                                false
                            )

                            // This if check gives us a "singleTop" behavior where we do not create a
                            // second instance of the composable if we are already on that destination
                            /*if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }*/
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController,
            modifier = Modifier.padding(padding),
            startDestination = Screen.ListPolls.route
        ) {
            composable(Screen.ListPolls.route) { }
        }
    }
}