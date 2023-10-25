package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.components.Section
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.designsystem.values.Paddings
import fr.alefaux.pollochon.feature.home.R
import fr.alefaux.pollochon.feature.home.models.HomeSurveysUi
import fr.alefaux.pollochon.feature.home.models.mock.homeSurveysUiMock

@Composable
fun HomeContentScreen(
    modifier: Modifier = Modifier,
    homeSurveys: HomeSurveysUi
) {
    Column(
        modifier = modifier
    ) {
        HomeHeader(
            modifier = Modifier.padding(horizontal = Paddings.screen),
            title = stringResource(id = R.string.home_title)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = Paddings.screen)
                .padding(bottom = Paddings.screen),
            verticalArrangement = Arrangement.spacedBy(Paddings.medium)
        ) {
            homeSurveys.invited?.let { invitedSurvey ->
                Section(
                    title = "Surveys invités",
                    onSeeAllClicked = {},
                ) {
                    SurveyItem(
                        survey = invitedSurvey,
                        onSurveyClicked = {},
                        onShareSurveyClicked = {}
                    )
                }
            }
            homeSurveys.own?.let { ownSurvey ->
                Section(
                    title = "Vos surveys",
                    onSeeAllClicked = {},
                ) {
                    SurveyItem(
                        survey = ownSurvey,
                        onSurveyClicked = {},
                        onShareSurveyClicked = {}
                    )
                }
            }
            homeSurveys.participated?.let { participatedSurvey ->
                Section(
                    title = "Surveys participés",
                    onSeeAllClicked = {},
                ) {
                    SurveyItem(
                        survey = participatedSurvey,
                        onSurveyClicked = {},
                        onShareSurveyClicked = {}
                    )
                }
            }
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
                homeSurveys = homeSurveysUiMock
            )
        }
    }
}
