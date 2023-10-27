package fr.alefaux.pollochon.feature.profile.screen.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.alefaux.pollochon.core.designsystem.components.DefaultProfileImage
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun ProfileImage(
    url: String?,
    onImageClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onImageClicked() }
            .size(128.dp)
    ) {
        if (url != null) {
            AsyncImage(
                model = url,
                contentDescription = null
            )
        } else {
            DefaultProfileImage(
                modifier = Modifier.fillMaxSize()
            )
        }
        Icon(
            imageVector = Icons.Rounded.Edit,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .background(Color.Gray, CircleShape)
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
@Preview
fun ProfileImagePreview() {
    PollochonTheme {
        ProfileImage(
            url = null,
            onImageClicked = {}
        )
    }
}
