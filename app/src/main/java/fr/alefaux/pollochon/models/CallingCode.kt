package fr.alefaux.pollochon.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CallingCode(
    @SerializedName("alpha2Code") val countryCode: String,
    @SerializedName("callingCodes") val callingCodes: List<String>,
    @SerializedName("flag") val flagUrl: String,
    @SerializedName("translations") val translations: Translations
) : Parcelable

@Parcelize
data class Translations(
    @SerializedName("de") val german: String,
    @SerializedName("es") val spanish: String,
    @SerializedName("fr") val french: String,
    @SerializedName("ja") val japanese: String,
    @SerializedName("it") val italian: String,
    @SerializedName("br") val breton: String,
    @SerializedName("pt") val portuguese: String,
    @SerializedName("nl") val dutch: String,
    @SerializedName("hr") val croatian: String,
    @SerializedName("fa") val persian: String
) : Parcelable