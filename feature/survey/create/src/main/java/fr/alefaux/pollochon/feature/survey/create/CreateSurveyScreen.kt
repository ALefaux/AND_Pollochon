package fr.alefaux.pollochon.feature.survey.create

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.HeaderScreen
import fr.alefaux.pollochon.core.designsystem.components.textinputs.DateTimeTextField
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.feature.survey.create.components.CreateSurveyPrincipalInfoScreen
import fr.alefaux.pollochon.feature.survey.create.components.CreateSurveyProposalsScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.compose.koinViewModel
import java.util.Calendar
import java.util.Date

@Composable
fun CreateSurveyScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateSurveyViewModel = koinViewModel(),
    onAccountClicked: () -> Unit,
) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var titleState: TextFieldState by remember { mutableStateOf(TextFieldState.None) }
    var typeSelected: SurveyType? by remember { mutableStateOf(null) }
    var endDate: Date? by remember { mutableStateOf(null) }
    var proposals by remember { mutableStateOf(listOf<String>()) }
    var showAddProposal by remember { mutableStateOf(false) }
    var proposalText by remember { mutableStateOf("") }

    when (val state = viewModel.createResultState.collectAsState().value) {
        CreateResultState.Success -> {
            CreateSurveyToast(
                message = stringResource(id = R.string.create_survey_success)
            )
            title = ""
            typeSelected = null
            endDate = null
            proposals = listOf()
            showAddProposal = false
            proposalText = ""
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

    CreateSurveyScreen(
        modifier = modifier,
        pageIndex = viewModel.indexPage.collectAsState().value,
        title = title,
        typeSelected = typeSelected,
        endDate = endDate,
        isCreatingSurvey = viewModel.loadingState.collectAsState().value,
        titleState = titleState,
        proposals = proposals,
        onAccountClicked = onAccountClicked,
        proposalText = proposalText,
        onTitleChanged = { titleChanged ->
            title = titleChanged
            titleState = if (title.isEmpty()) {
                TextFieldState.None
            } else if (title.length in 10..100) {
                TextFieldState.Success
            } else {
                TextFieldState.Error
            }
        },
        onTypeChanged = { typeChanged ->
            typeSelected = typeChanged
        },
        onEndDateChanged = { endDateChanged ->
            endDate = endDateChanged
        },
        onValidateClicked = {
            if (proposals.size >= 2) {
                typeSelected?.let { type ->
                    viewModel.createSurvey(title, type, endDate, proposals)
                } ?: Toast.makeText(
                    context,
                    context.getString(R.string.create_survey_error),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    context,
                    context.getString(R.string.create_survey_make_proposals),
                    Toast.LENGTH_LONG
                ).show()
            }
        },
        onProposalValidated = { index, proposal ->
            val newProposals = proposals.toMutableList()
            if (index != null) {
                newProposals[index] = proposal
            } else {
                newProposals.add(proposal)
            }
            proposals = newProposals
            proposalText = ""
            showAddProposal = false
        },
        onProposalTextChanged = { text ->
            proposalText = text
        },
        onPreviousClicked = {
            viewModel.previousPage()
        },
        onFirstScreenNextClicked = {
            if (title.isNotBlank() && typeSelected != null) {
                viewModel.nextPage()
            } else {
                if (title.isBlank()) {
                    titleState = TextFieldState.Error
                }

                if (typeSelected == null) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.create_survey_select_type),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    )
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

@Composable
internal fun CreateSurveyScreen(
    modifier: Modifier = Modifier,
    pageIndex: Int,
    title: String,
    typeSelected: SurveyType?,
    endDate: Date?,
    isCreatingSurvey: Boolean,
    titleState: TextFieldState,
    proposals: List<String>,
    proposalText: String,
    onAccountClicked: () -> Unit,
    onTitleChanged: (String) -> Unit,
    onTypeChanged: (SurveyType) -> Unit,
    onEndDateChanged: (Date) -> Unit,
    onValidateClicked: () -> Unit,
    onProposalValidated: (Int?, String) -> Unit,
    onProposalTextChanged: (String) -> Unit,
    onPreviousClicked: () -> Unit,
    onFirstScreenNextClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        HeaderScreen(
            title = stringResource(id = R.string.title_create_survey),
            userImageUrl = null,
            onAccountClicked = onAccountClicked,
        )
        when (pageIndex) {
            0 -> CreateSurveyPrincipalInfoScreen(
                title = title,
                titleState = titleState,
                onTitleChanged = onTitleChanged,
                typeSelected = typeSelected,
                onTypeChanged = onTypeChanged,
                endDate = endDate,
                onEndDateChanged = onEndDateChanged,
                onNextClicked = onFirstScreenNextClicked
            )

            1 -> CreateSurveyProposalsScreen(
                proposals = proposals,
                proposal = proposalText,
                onProposalTextChanged = onProposalTextChanged,
                onProposalValidated = onProposalValidated,
                onPreviousClicked = onPreviousClicked,
                onValidateClicked = onValidateClicked
            )
        }
    }
}

@Composable
internal fun CreateSurveyType(
    typeSelected: SurveyType?,
    onTypeChanged: (SurveyType) -> Unit,
) {
    Text(
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
        text = "Type (mandatory)",
        style = PollochonTheme.typography.body2Bold,
        color = PollochonTheme.colors.pollochonContentPrimary,
    )
    CreateSurveyViewModel.typeItems.forEach { item ->
        Card(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable {
                    onTypeChanged(item.type)
                },
            border = if (item.type == typeSelected) {
                BorderStroke(2.dp, PollochonTheme.colors.pollochonBorderPrimary)
            } else {
                null
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.width(38.dp),
                    text = item.icon,
                    style = PollochonTheme.typography.h6,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = item.title,
                    style = PollochonTheme.typography.body2,
                )
            }
        }
    }
}

@Composable
internal fun CreateSurveyEndDate(
    endDate: Date?,
    onEndDateChanged: (Date) -> Unit,
) {
    Text(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        text = "Date de fin",
        style = PollochonTheme.typography.body2Bold,
        color = PollochonTheme.colors.pollochonContentPrimary,
    )
    DateTimeTextField(
        date = endDate,
        onValueChange = { valueChange ->
            onEndDateChanged(valueChange)
        },
    )
}

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun CreateSurveyScreenPreview() {
    PollochonTheme {
        Scaffold { paddingValues ->
            CreateSurveyScreen(
                modifier = Modifier.padding(paddingValues),
                pageIndex = 0,
                title = "",
                typeSelected = null,
                endDate = Calendar.getInstance().time,
                isCreatingSurvey = false,
                titleState = TextFieldState.None,
                proposals = listOf(
                    "Item 1",
                    "Item 2",
                ),
                proposalText = "",
                onAccountClicked = {},
                onTitleChanged = {},
                onTypeChanged = {},
                onEndDateChanged = {},
                onValidateClicked = {},
                onProposalValidated = { _, _ -> },
                onProposalTextChanged = { _ -> },
                onPreviousClicked = {},
                onFirstScreenNextClicked = {}
            )
        }
    }
}
