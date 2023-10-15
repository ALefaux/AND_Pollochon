package fr.alefaux.pollochon.core.model.extensions

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date

fun Date.toIso(): String {
    return LocalDateTime.ofInstant(this.toInstant(), ZoneId.systemDefault())
        .format(DateTimeFormatter.ISO_DATE_TIME)
}