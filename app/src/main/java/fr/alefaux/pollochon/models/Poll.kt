package fr.alefaux.pollochon.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Poll(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: Type,
    @SerializedName("createdAt") val createdAt: Date,
    @SerializedName("activities") val activities: List<String>,
    @SerializedName("endedAt") val endedAt: Date,
    @SerializedName("owner") val owner: User
): Parcelable {
    enum class Type {
        SINGLE, MULTIPLE, MARBLE
    }
}