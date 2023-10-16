package fr.alefaux.pollochon.feature.survey.create

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import fr.alefaux.pollochon.core.designsystem.values.Paddings
import fr.alefaux.pollochon.feature.survey.create.components.CreateSurveyPrincipalInfoScreen
import fr.alefaux.pollochon.feature.survey.create.components.CreateSurveyProposalsScreen
import fr.alefaux.pollochon.feature.survey.create.models.CreateResultState
import fr.alefaux.pollochon.feature.survey.create.models.CreateSurveyUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateSurveyScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateSurveyViewModel = koinViewModel()
) {
    when (val state = viewModel.createResultState.collectAsState().value) {
        CreateResultState.Success -> {
            CreateSurveyToast(
                message = stringResource(id = R.string.create_survey_success)
            )
        }

        is CreateResultState.Error.Unknown -> state.message?.let { message ->
            CreateSurveyToast(message = message)
        }

        CreateResultState.Error.UserNotFound -> CreateSurveyToast(
            message = stringResource(id = R.string.create_survey_error_user_not_found)
        )

        CreateResultState.Error.BadRequest -> CreateSurveyToast(
            message = stringResource(id = R.string.create_survey_error_bad_request)
        )

        else -> {}
    }

    Column(
        modifier = modifier
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.title_create_survey))
            }
        )
        when (val state = viewModel.uiState.collectAsState().value) {
            is CreateSurveyUiState.PrincipalInfo -> CreateSurveyPrincipalInfoScreen(
                modifier = Modifier.padding(all = Paddings.screen),
                createSurveyUi = state.createSurveyUi,
                onNextClicked = { title, surveyType, endDate ->
                    viewModel.nextPage(title, surveyType, endDate)
                }
            )

            is CreateSurveyUiState.Proposals -> CreateSurveyProposalsScreen(
                modifier = Modifier.padding(all = Paddings.screen),
                proposals = state.proposals,
                isSendingSurvey = viewModel.loadingState.collectAsState().value,
                onPreviousClicked = { proposals ->
                    viewModel.previousPage(proposals)
                },
                onValidateClicked = { proposals ->
                    viewModel.createSurvey(proposals)
                }
            )
        }
    }
}

@Composable
internal fun CreateSurveyToast(message: String) {
    val context = LocalContext.current

    Toast.makeText(
        context,
        message,
        Toast.LENGTH_LONG
    ).show()
}
