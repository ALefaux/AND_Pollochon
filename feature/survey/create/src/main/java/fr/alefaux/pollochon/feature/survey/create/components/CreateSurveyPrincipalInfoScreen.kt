package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.components.textinputs.PollochonTextInputs
import fr.alefaux.pollochon.core.designsystem.components.textinputs.TextInputsState
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.feature.survey.create.CreateSurveyEndDate
import fr.alefaux.pollochon.feature.survey.create.CreateSurveyType
import fr.alefaux.pollochon.feature.survey.create.R
import fr.alefaux.pollochon.feature.survey.create.TextFieldState
import java.util.Date

@Composable
fun CreateSurveyPrincipalInfoScreen(
    modifier: Modifier = Modifier,
    title: String,
    titleState: TextFieldState,
    onTitleChanged: (String) -> Unit,
    typeSelected: SurveyType?,
    onTypeChanged: (SurveyType) -> Unit,
    endDate: Date?,
    onEndDateChanged: (Date) -> Unit,
    onNextClicked: () -> Unit
) {
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
        CreateSurveyType(
            typeSelected = typeSelected,
            onTypeChanged = onTypeChanged,
        )
        CreateSurveyEndDate(
            endDate = endDate,
            onEndDateChanged = onEndDateChanged,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PollochonButtons.Primary(
                text = "Suivant",
                onClick = onNextClicked
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateSurveyPrincipalInfoScreenPreview() {
    PollochonTheme {
        CreateSurveyPrincipalInfoScreen(
            title = "Premier survey",
            titleState = TextFieldState.None,
            onTitleChanged = {},
            typeSelected = SurveyType.SIMPLE,
            onTypeChanged = {},
            endDate = Date(),
            onEndDateChanged = {},
            onNextClicked = {}
        )
    }
}
