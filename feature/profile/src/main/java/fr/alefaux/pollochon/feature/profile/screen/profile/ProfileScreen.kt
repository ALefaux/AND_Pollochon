package fr.alefaux.pollochon.feature.profile.screen.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.ui.LoadingScreen
import fr.alefaux.pollochon.feature.profile.screen.profile.component.ProfileContent
import fr.alefaux.pollochon.feature.profile.model.ProfileState
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel(),
    onSeeAllFriendsScreen: () -> Unit
) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is ProfileState.Loading -> LoadingScreen()
        is ProfileState.Loaded -> ProfileContent(
            profileUi = state.profileUi,
            friendsState = viewModel.friends.collectAsState().value,
            onLogoutButtonClicked = {
                viewModel.logout()
            },
            onSeeAllFriendsClicked = onSeeAllFriendsScreen
        )

        is ProfileState.Error -> Text("Error")
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePreview() {
    PollochonTheme {
        ProfileScreen(
            onSeeAllFriendsScreen = {}
        )
    }
}