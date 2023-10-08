package fr.alefaux.pollochon.core.designsystem.components.textinputs

import android.app.DatePickerDialog
import android.text.format.DateFormat
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar
import java.util.Date

@Composable
fun DateTimeTextField(
    date: Date?,
    onValueChange: (Date) -> Unit,
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
            calendar.set(Calendar.YEAR, selectedYear)
            calendar.set(Calendar.MONTH, selectedMonth)
            calendar.set(Calendar.DAY_OF_MONTH, selectedDayOfMonth)
            onValueChange(calendar.time)
        }, year.value, month.value, dayOfMonth.value
    ).apply {
        datePicker.minDate = calendar.timeInMillis
    }

    Box(modifier = modifier) {
        PollochonTextInputs.Outlined(
            value = if (date != null) DateFormat.getDateFormat(context).format(date) else "",
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
