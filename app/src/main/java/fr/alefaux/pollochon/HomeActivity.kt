package fr.alefaux.pollochon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import fr.alefaux.pollochon.views.home.HomeContentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition {
            homeViewModel.uiState.value is HomeUiState.Loading
        }

        setContent {
            when (homeViewModel.uiState.collectAsState().value) {
                is HomeUiState.Home -> HomeContentScreen()
                is HomeUiState.Login -> Text("Need to login!")
                else -> {
                    // Show an error
                }
            }
        }
    }
}
