package fr.alefaux.pollochon.feature.survey.create.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.components.textinputs.PollochonTextInputs
import fr.alefaux.pollochon.core.designsystem.components.textinputs.TextInputsState
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.feature.survey.create.R
import fr.alefaux.pollochon.feature.survey.create.models.CreateSurveyUi
import fr.alefaux.pollochon.feature.survey.create.models.TextFieldState
import java.util.Date

@Composable
fun CreateSurveyPrincipalInfoScreen(
    modifier: Modifier = Modifier,
    createSurveyUi: CreateSurveyUi,
    onNextClicked: (String, SurveyType, Date?) -> Unit
) {
    val context: Context = LocalContext.current
    var title by remember { mutableStateOf(createSurveyUi.title) }
    var titleState: TextFieldState by remember {
        mutableStateOf(getTitleFieldState(createSurveyUi.title))
    }
    var typeSelected: SurveyType? by remember { mutableStateOf(createSurveyUi.type) }
    var endDate: Date? by remember { mutableStateOf(createSurveyUi.endDate) }

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = "Name (mandatory)",
            style = PollochonTheme.typography.body2Bold,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        PollochonTextInputs.Outlined(
            value = title,
            onValueChange = { textChanged ->
                title = textChanged
                titleState = getTitleFieldState(textChanged)
            },
            singleLine = true,
            colors = when (titleState) {
                is TextFieldState.None -> TextInputsState.normal()
                is TextFieldState.Error -> TextInputsState.error()
                is TextFieldState.Success -> TextInputsState.success()
            },
            helperText = stringResource(id = R.string.requirement_title_survey)
        )
        CreateSurveyType(
            typeSelected = typeSelected,
            onTypeChanged = { surveyType ->
                typeSelected = surveyType
            },
        )
        CreateSurveyEndDate(
            endDate = endDate,
            onEndDateChanged = { newDate ->
                endDate = newDate
            },
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PollochonButtons.Primary(
                text = "Suivant",
                onClick = {
                    if (title.isNotBlank()) {
                        typeSelected?.let { type ->
                            onNextClicked(title, type, endDate)
                        } ?: Toast.makeText(
                            context,
                            context.getString(R.string.create_survey_select_type),
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        if (title.isBlank()) {
                            titleState = TextFieldState.Error
                        }
                    }
                }
            )
        }
    }
}

internal fun getTitleFieldState(title: String): TextFieldState {
    return if (title.isEmpty()) {
        TextFieldState.None
    } else if (title.length in 10..100) {
        TextFieldState.Success
    } else {
        TextFieldState.Error
    }
}

@Composable
@Preview(showBackground = true)
fun CreateSurveyPrincipalInfoScreenPreview() {
    PollochonTheme {
        CreateSurveyPrincipalInfoScreen(
            createSurveyUi = CreateSurveyUi(
                title = "",
                type = null,
                endDate = null
            ),
            onNextClicked = { _, _, _ -> }
        )
    }
}
