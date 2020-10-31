package fr.alefaux.pollochon.views.listpolls

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.ui.tooling.preview.Preview
import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.models.User
import java.util.*


@Composable
fun ListPollsRow(poll: Poll) {
    //val owner: String = if (poll.owner.id == ownerId) "Vous" else poll.owner.fullName

    Column {
        // val (titleText) = createRefs()

        Text(poll.title)
        Text("Créé par")
    }
}

@Preview
@Composable
fun ListPollsRow_Preview() {
    ListPollsRow(
        poll = Poll(
            1,
            "First Poll",
            Poll.Type.SINGLE,
            Date(),
            listOf(),
            Date(),
            User(1, "Axel", "Lefaux")
        )
    )
}