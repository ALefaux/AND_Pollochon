package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.HeaderScreen
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.home.R
import fr.alefaux.pollochon.feature.home.models.HomeSurveysUi
import fr.alefaux.pollochon.feature.home.models.mock.homeSurveysUiMock

@Composable
fun HomeContentScreen(
    modifier: Modifier = Modifier,
    homeSurveys: HomeSurveysUi,
    onAccountClicked: () -> Unit,

) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HeaderScreen(
            title = stringResource(id = R.string.home_title),
            onAccountClicked = onAccountClicked
        )
        homeSurveys.invited?.let { invitedSurvey ->
            HomeContentSection(
                title = "Surveys invités",
                lastSurvey = invitedSurvey,
                onSeeAllClicked = {},
                onSurveyClicked = {},
                onShareSurveyClicked = {},
            )
        }
        homeSurveys.own?.let { ownSurvey ->
            HomeContentSection(
                title = "Vos surveys",
                lastSurvey = ownSurvey,
                onSeeAllClicked = {},
                onSurveyClicked = {},
                onShareSurveyClicked = {},
            )
        }
        homeSurveys.participated?.let { participatedSurvey ->
            HomeContentSection(
                title = "Surveys participés",
                lastSurvey = participatedSurvey,
                onSeeAllClicked = {},
                onSurveyClicked = {},
                onShareSurveyClicked = {},
            )
        }
    }
}

@Composable
@Preview
fun HomeContentScreenPreview() {
    PollochonTheme {
        Scaffold { paddingValues ->
            HomeContentScreen(
                modifier = Modifier.padding(paddingValues),
                homeSurveys = homeSurveysUiMock,
                onAccountClicked = {}
            )
        }
    }
}
