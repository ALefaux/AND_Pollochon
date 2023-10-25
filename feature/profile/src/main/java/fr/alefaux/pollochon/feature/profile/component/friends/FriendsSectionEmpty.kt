package fr.alefaux.pollochon.feature.profile.component.friends

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FriendsSectionEmpty(
    modifier: Modifier = Modifier
) = Text(
    modifier = modifier
        .fillMaxWidth(),
    text = "Add new friend",
    textAlign = TextAlign.Center
)


    /*Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    PollochonButtons.Primary(
        text = "Add new friend",
        onClick = onAddFriendClicked
    )
}*/