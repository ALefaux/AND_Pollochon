package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.ArrowRight
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.home.models.SurveyUi
import fr.alefaux.pollochon.feature.home.models.mock.surveyUiMock

@Composable
fun HomeContentSection(
    modifier: Modifier = Modifier,
    title: String,
    lastSurvey: SurveyUi,
    onSeeAllClicked: () -> Unit,
    onSurveyClicked: (Int) -> Unit,
    onShareSurveyClicked: (Int) -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                style = PollochonTheme.typography.h5,
                color = PollochonTheme.colors.pollochonContentPrimary
            )
            IconButton(
                onClick = onSeeAllClicked,
                content = {
                    Icon(
                        imageVector = PollochonIcons.Line.ArrowRight,
                        contentDescription = null,
                        tint = PollochonTheme.colors.pollochonContentPrimary
                    )
                }
            )
        }
        SurveyItem(
            survey = lastSurvey,
            onSurveyClicked = onSurveyClicked,
            onShareSurveyClicked = onShareSurveyClicked,
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeContentSectionPreview() {
    PollochonTheme {
        HomeContentSection(
            title = "Home content section",
            lastSurvey = surveyUiMock,
            onSeeAllClicked = {},
            onSurveyClicked = {},
            onShareSurveyClicked = {},
        )
    }
}