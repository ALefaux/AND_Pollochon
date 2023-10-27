package fr.alefaux.pollochon.feature.profile.screen.profile.component.friends

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.components.Section
import fr.alefaux.pollochon.core.designsystem.components.skeletons.skeleton
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.profile.model.FriendsState

@Composable
fun FriendsSection(
    modifier: Modifier = Modifier,
    friendsState: FriendsState,
    seeAllClicked: () -> Unit
) = Section(
    modifier = modifier,
    title = "Friends",
    onSeeAllClicked = seeAllClicked
) {
    when (friendsState) {
        is FriendsState.Loading -> FriendsSectionLoading()
        is FriendsState.Loaded -> FriendsSectionLoaded(
            friends = friendsState.friends
        )

        is FriendsState.Empty -> FriendsSectionEmpty()

        else -> {}
    }
}

@Composable
@Preview(showBackground = true)
fun FriendsSectionPreview() {
    PollochonTheme {
        FriendsSection(
            friendsState = FriendsState.Loading,
            seeAllClicked = {}
        )
    }
}
