package fr.alefaux.pollochon.feature.profile.screen.profile.component.friends

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.model.user.User

@Composable
fun FriendsSectionLoaded(
    modifier: Modifier = Modifier,
    friends: List<User>
) = LazyVerticalGrid(
    modifier = modifier,
    columns = GridCells.Adaptive(minSize = 128.dp)
) {
    friends.forEach { friend ->
        item {
            Text(text = "Item ${friend.userName}")
        }
    }
}