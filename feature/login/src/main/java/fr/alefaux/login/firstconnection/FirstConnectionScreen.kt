package fr.alefaux.login.firstconnection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun FirstConnectionScreen(
    modifier: Modifier = Modifier,
    isCreatingUserName: Boolean,
    pseudoErrorMessage: String,
    onRegisterButtonClicked: (String) -> Unit
) {
    var pseudo by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("First connection?")
        Text("Get a name for your profile")
        TextField(
            value = pseudo,
            onValueChange = { pseudo = it },
            isError = pseudoErrorMessage.isNotBlank(),
            singleLine = true
        )
        if (pseudoErrorMessage.isNotBlank()) {
            Text(pseudoErrorMessage, color = Color.Red)
        }
        Button(onClick = {
            onRegisterButtonClicked(pseudo)
        }) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Enregistrer")
                if (isCreatingUserName) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstConnectionPreview() {
    PollochonTheme {
        FirstConnectionScreen(
            isCreatingUserName = false,
            pseudoErrorMessage = ""
        ) {}
    }
}

@Composable
@Preview(showBackground = true)
fun FirstConnectionWithErrorPreview() {
    PollochonTheme {
        FirstConnectionScreen(
            isCreatingUserName = true,
            pseudoErrorMessage = "Pseudo already used"
        ) {}
    }
}
