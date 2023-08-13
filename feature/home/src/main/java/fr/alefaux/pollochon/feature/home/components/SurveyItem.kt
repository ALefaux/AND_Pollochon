package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.home.models.SurveyUi
import fr.alefaux.pollochon.feature.home.models.mock.surveyUiMock

@Composable
fun SurveyItem(
    modifier: Modifier = Modifier,
    survey: SurveyUi,
    onSurveyClicked: (Int) -> Unit,
    onShareSurveyClicked: (Int) -> Unit,
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .clickable {
                onSurveyClicked(survey.id)
            },
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color.Cyan,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp, bottom = 16.dp)
                .weight(1f)
                .fillMaxHeight()
        ) {
            UserTag(
                userName = survey.userName,
                userImage = survey.userImageUrl,
            )
            Text(
                text = survey.title,
                style = PollochonTheme.typography.h6
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SurveyItemAction(
                title = "Votes",
                text = survey.numberAnswered,
            )
            SurveyItemAction(
                title = "Share",
                text = survey.numberShared,
                onClick = {
                    onShareSurveyClicked(survey.id)
                },
            )
        }
    }
}

@Composable
private fun SurveyItemAction(
    title: String,
    text: String,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .background(
                color = Color.Cyan,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = PollochonTheme.typography.body2
        )
        Text(
            text = text,
            style = PollochonTheme.typography.body1Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SurveyItemPreview() {
    PollochonTheme {
        SurveyItem(
            survey = surveyUiMock,
            onSurveyClicked = {},
            onShareSurveyClicked = {},
        )
    }
}
