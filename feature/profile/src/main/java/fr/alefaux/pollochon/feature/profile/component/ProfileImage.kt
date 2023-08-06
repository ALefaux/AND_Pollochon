package fr.alefaux.pollochon.feature.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.alefaux.pollochon.core.designsystem.R as DesignSystemR

@Composable
fun ProfileImage(
    url: String?,
    onImageClicked: () -> Unit
) {
    Box(
        modifier = Modifier.clickable { onImageClicked() }
            .size(128.dp)
    ) {
        if (url != null) {
            AsyncImage(
                model = url,
                contentDescription = null
            )
        } else {
            DefaultProfileImage()
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
fun DefaultProfileImage() {
    Image(
        painter = painterResource(id = DesignSystemR.drawable.ic_logo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Blue, CircleShape)
    )
}
