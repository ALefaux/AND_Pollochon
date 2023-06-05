package fr.alefaux.pollochon.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import fr.alefaux.pollochon.core.ui.GenericView
import fr.alefaux.pollochon.core.ui.LoadingScreen
import fr.alefaux.pollochon.feature.home.components.HomeContentScreen
import fr.alefaux.pollochon.feature.home.models.HomeUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState: HomeUiState = viewModel.homeUiState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.fetchHomeSurveys()
    }

    HomeScreen(uiState)
}

@Composable
internal fun HomeScreen(uiState: HomeUiState) {
    when (uiState) {
        HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Loaded -> HomeContentScreen()
        HomeUiState.Error -> GenericView.Error()
        HomeUiState.Empty -> GenericView.Empty()
    }
}
