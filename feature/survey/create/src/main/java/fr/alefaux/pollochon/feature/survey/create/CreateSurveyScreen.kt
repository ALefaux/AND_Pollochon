package fr.alefaux.pollochon.feature.survey.create

import android.app.DatePickerDialog
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.HeaderScreen
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.components.textinputs.PollochonTextInputs
import fr.alefaux.pollochon.core.designsystem.components.textinputs.TextInputsState
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.util.Calendar

@Composable
fun CreateSurveyScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateSurveyViewModel = koinViewModel(),
    onAccountClicked: () -> Unit,
) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var typeSelected: SurveyType? by remember { mutableStateOf(null) }
    var endDate by remember { mutableStateOf("") }

    when (viewModel.createResultState.collectAsState().value) {
        CreateResultState.Success -> {
            CreateSurveyToast(
                message = stringResource(id = R.string.create_survey_success)
            )
            title = ""
            typeSelected = null
            endDate = ""
        }

        CreateResultState.Error -> CreateSurveyToast(
            stringResource(id = R.string.create_survey_success),
        )

        else -> {}
    }

    CreateSurveyScreen(
        modifier = modifier,
        title = title,
        typeSelected = typeSelected,
        endDate = endDate,
        isCreatingSurvey = viewModel.loadingState.collectAsState().value,
        titleState = viewModel.titleState.collectAsState().value,
        onAccountClicked = onAccountClicked,
        onTitleChanged = { titleChanged ->
            title = titleChanged
            viewModel.validateTitle(titleChanged)
        },
        onTypeChanged = { typeChanged ->
            typeSelected = typeChanged
        },
        onEndDateChanged = { endDateChanged ->
            endDate = endDateChanged
        },
        onValidateClicked = {
            typeSelected?.let { type ->
                viewModel.createSurvey(title, type)
            } ?: run {
                Toast.makeText(
                    context,
                    context.getString(R.string.create_survey_select_type),
                    Toast.LENGTH_LONG
                ).show()
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
    title: String,
    typeSelected: SurveyType?,
    endDate: String,
    isCreatingSurvey: Boolean,
    titleState: TextFieldState,
    onAccountClicked: () -> Unit,
    onTitleChanged: (String) -> Unit,
    onTypeChanged: (SurveyType) -> Unit,
    onEndDateChanged: (String) -> Unit,
    onValidateClicked: () -> Unit,
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
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = "Name *",
            style = PollochonTheme.typography.body2,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        PollochonTextInputs.Outlined(
            value = title,
            onValueChange = { textChanged ->
                onTitleChanged(textChanged)
            },
            singleLine = true,
            colors = when (titleState) {
                is TextFieldState.None -> TextInputsState.normal()
                is TextFieldState.Error -> TextInputsState.error()
                is TextFieldState.Success -> TextInputsState.success()
            },
            helperText = stringResource(id = R.string.requirement_title_survey)
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = "Type *",
            style = PollochonTheme.typography.body2,
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
                ) {
                    Text(
                        text = item.icon,
                    )
                    Text(
                        text = item.title,
                    )
                }
            }
        }
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "Date de fin",
            style = PollochonTheme.typography.body2,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        DateTimeTextField(
            value = endDate,
            onValueChange = { valueChange ->
                onEndDateChanged(valueChange)
            },
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.Center,
        ) {
            PollochonButtons.Primary(
                modifier = Modifier.fillMaxWidth(),
                text = if (!isCreatingSurvey) {
                    "Créer"
                } else {
                    ""
                },
                onClick = onValidateClicked
            )
            if (isCreatingSurvey) {
                CircularProgressIndicator(
                    color = PollochonTheme.colors.pollochonContentPrimaryReversed
                )
            }
        }
    }
}

@Composable
fun DateTimeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Fetching current year, month and day
    val year = remember { mutableStateOf(calendar[Calendar.YEAR]) }
    val month = remember { mutableStateOf(calendar[Calendar.MONTH]) }
    val dayOfMonth = remember { mutableStateOf(calendar[Calendar.DAY_OF_MONTH]) }

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            year.value = selectedYear
            month.value = selectedMonth
            dayOfMonth.value = selectedDayOfMonth
            onValueChange("$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear")
        }, year.value, month.value, dayOfMonth.value
    ).apply {
        datePicker.minDate = calendar.timeInMillis
    }

    Box(modifier = modifier) {
        PollochonTextInputs.Outlined(
            value = value,
            onValueChange = {}
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0f)
                .clickable {
                    datePicker.show()
                }
        )
    }
}

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun CreateSurveyScreenPreview() {
    PollochonTheme {
        Scaffold { paddingValues ->
            CreateSurveyScreen(
                modifier = Modifier.padding(paddingValues),
                title = "",
                typeSelected = null,
                endDate = "",
                isCreatingSurvey = false,
                titleState = TextFieldState.None,
                onAccountClicked = {},
                onTitleChanged = {},
                onTypeChanged = {},
                onEndDateChanged = {},
                onValidateClicked = {}
            )
        }
    }
}
