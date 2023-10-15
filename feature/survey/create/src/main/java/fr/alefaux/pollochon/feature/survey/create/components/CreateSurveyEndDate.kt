package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.textinputs.DateTimeTextField
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import java.util.Date

@Composable
fun CreateSurveyEndDate(
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
