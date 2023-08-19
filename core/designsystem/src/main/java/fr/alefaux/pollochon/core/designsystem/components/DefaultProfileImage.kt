package fr.alefaux.pollochon.core.designsystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.User
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun DefaultProfileImage(
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = PollochonIcons.Line.User,
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape),
        tint = PollochonTheme.colors.pollochonContentPrimary,
    )
}

@Composable
@Preview
fun DefaultProfileImagePreview() {
    PollochonTheme {
        DefaultProfileImage(
            modifier = Modifier.size(128.dp)
        )
    }
}
