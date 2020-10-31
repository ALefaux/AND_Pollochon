package fr.alefaux.pollochon.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Poll(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Type,
    @SerializedName("createdAt") val createdAt: Date,
    @SerializedName("activities") val activities: List<String>,
    @SerializedName("endedAt") val endedAt: Date,
    @SerializedName("owner") val owner: User
) {
    enum class Type {
        SINGLE, MULTIPLE, MARBLE
    }
}