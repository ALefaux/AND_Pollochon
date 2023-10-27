package fr.alefaux.pollochon.feature.profile.screen.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.profile.screen.profile.component.friends.FriendsSection
import fr.alefaux.pollochon.feature.profile.model.FriendsState
import fr.alefaux.pollochon.feature.profile.model.ProfileUi
import fr.alefaux.pollochon.feature.profile.model.mock.profileUiMock

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    profileUi: ProfileUi,
    friendsState: FriendsState,
    onLogoutButtonClicked: () -> Unit,
    onSeeAllFriendsClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileImage(
            url = profileUi.userImageUrl,
            onImageClicked = {}
        )
        Text(
            text = profileUi.userName,
            style = PollochonTheme.typography.h4,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        FriendsSection(
            friendsState = friendsState,
            seeAllClicked = onSeeAllFriendsClicked
        )
        Spacer(modifier = Modifier.weight(1f))
        PollochonButtons.Primary(
            modifier = Modifier.fillMaxWidth(),
            text = "Déconnexion",
            onClick = onLogoutButtonClicked,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileContentPreview() {
    PollochonTheme {
        ProfileContent(
            profileUi = profileUiMock,
            friendsState = FriendsState.Loading,
            onLogoutButtonClicked = {},
            onSeeAllFriendsClicked = {}
        )
    }
}
