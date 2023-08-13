package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.User
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserTag(
    modifier: Modifier = Modifier,
    userName: String,
    userImage: String?,
) {
    Chip(
        modifier = modifier,
        onClick = { /*TODO*/ },
        leadingIcon = {
            if(userImage.isNullOrBlank()) {
                Icon(
                    modifier = Modifier
                        .background(
                            color = PollochonTheme.colors.pollochonBackgroundPrimary,
                            shape = CircleShape,
                        )
                        .padding(
                            all = 4.dp
                        )
                        .size(18.dp),
                    imageVector = PollochonIcons.Line.User,
                    contentDescription = null
                )
            }
        },
        content = {
            Text(
                text = userName
            )
        },
    )
}

@Composable
@Preview(showBackground = true)
fun UserTagPreview() {
    PollochonTheme {
        UserTag(
            userName = "ALefaux",
            userImage = null,
        )
    }
}
