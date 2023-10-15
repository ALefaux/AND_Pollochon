package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.feature.survey.create.CreateSurveyViewModel

@Composable
fun CreateSurveyType(
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
