package fr.alefaux.pollochon.views.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import fr.alefaux.pollochon.views.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContentScreen() {
    val items = listOf(
        Screen.ListPolls,
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                // val navBackStackEntry by navController.currentBackStackEntryAsState()
                // val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = false,
                        onClick = {
                            // This is the equivalent to popUpTo the start destination
                            navController.popBackStack(
                                navController.graph.startDestinationId,
                                false,
                            )

                            // This if check gives us a "singleTop" behavior where we do not create a
                            // second instance of the composable if we are already on that destination
                            /*if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }*/
                        },
                    )
                }
            }
        },
    ) { padding ->
        /*NavHost(
            navController,
            modifier = Modifier.padding(padding),
            startDestination = Screen.ListPolls.route,
        ) {
            composable(Screen.ListPolls.route) { }
        }*/
        Button(
            onClick = { FirebaseAuth.getInstance().signOut() },
            modifier = Modifier.padding(padding)
        ) {
            Text("Deconnexion")
        }
    }
}
