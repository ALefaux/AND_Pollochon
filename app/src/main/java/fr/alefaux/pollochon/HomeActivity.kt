package fr.alefaux.pollochon

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import fr.alefaux.pollochon.views.home.HomeContentScreen
import fr.alefaux.pollochon.views.splashscreen.SplashScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            when (homeViewModel.uiState.collectAsState().value) {
                is HomeUiState.Splash -> SplashScreen()
                is HomeUiState.Home -> HomeContentScreen()
                is HomeUiState.Login -> Text("Need to login!")
            }
        }
    }

}