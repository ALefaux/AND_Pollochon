package fr.alefaux.pollochon.feature.profile.component.friends

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.skeletons.skeleton

@Composable
fun FriendsSectionLoading(
    modifier: Modifier = Modifier
) = LazyVerticalGrid(
    modifier = modifier.skeleton(),
    columns = GridCells.Adaptive(minSize = 128.dp)
) {
    (1..6).forEach { index ->
        item {
            Text(text = "Item $index")
        }
    }
}