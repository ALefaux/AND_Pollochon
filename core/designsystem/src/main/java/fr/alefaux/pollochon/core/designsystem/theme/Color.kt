package fr.alefaux.pollochon.core.designsystem.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.core.graphics.ColorUtils

const val PollochonStatesDisabled = .38f

object PollochonPalette {
    val pollochonPurple50 = Color(242, 237, 242)
    val pollochonPurple100 = Color(220, 207, 221)
    val pollochonPurple200 = Color(172, 141, 175)
    val pollochonPurple300 = Color(150, 111, 154)
    val pollochonPurple400 = Color(108, 78, 111)
    val pollochonPurple500 = Color(91, 65, 93)
    val pollochonPurple600 = Color(73, 53, 75)
    val pollochonPurple700 = Color(44, 32, 45)

    val pollochonBlue50 = Color(231, 243, 249)
    val pollochonBlue100 = Color(190, 222, 239)
    val pollochonBlue200 = Color(126, 190, 224)
    val pollochonBlue300 = Color(61, 154, 204)
    val pollochonBlue400 = Color(0, 125, 188)
    val pollochonBlue500 = Color(0, 104, 157)
    val pollochonBlue600 = Color(0, 83, 125)
    val pollochonBlue700 = Color(1, 43, 73)

    val pollochonGreen50 = Color(228, 249, 243)
    val pollochonGreen100 = Color(190, 239, 226)
    val pollochonGreen200 = Color(124, 223, 196)
    val pollochonGreen300 = Color(33, 206, 156)
    val pollochonGreen400 = Color(2, 190, 138)
    val pollochonGreen500 = Color(2, 158, 115)
    val pollochonGreen600 = Color(1, 127, 92)
    val pollochonGreen700 = Color(0, 111, 67)

    val pollochonConifer50 = Color(234, 251, 232)
    val pollochonConifer100 = Color(203, 240, 199)
    val pollochonConifer200 = Color(136, 215, 127)
    val pollochonConifer300 = Color(116, 199, 106)
    val pollochonConifer400 = Color(35, 169, 66)
    val pollochonConifer500 = Color(65, 160, 54)
    val pollochonConifer600 = Color(55, 141, 46)
    val pollochonConifer700 = Color(37, 108, 29)

    val pollochonYellow50 = Color(255, 254, 240)
    val pollochonYellow100 = Color(255, 251, 199)
    val pollochonYellow200 = Color(255, 245, 141)
    val pollochonYellow300 = Color(255, 243, 112)
    val pollochonYellow400 = Color(255, 234, 40)
    val pollochonYellow500 = Color(188, 176, 44)
    val pollochonYellow600 = Color(153, 144, 40)
    val pollochonYellow700 = Color(103, 97, 27)

    val pollochonOrange50 = Color(255, 243, 237)
    val pollochonOrange100 = Color(255, 228, 214)
    val pollochonOrange200 = Color(250, 195, 165)
    val pollochonOrange300 = Color(250, 156, 105)
    val pollochonOrange400 = Color(255, 96, 10)
    val pollochonOrange500 = Color(193, 94, 41)
    val pollochonOrange600 = Color(154, 75, 33)
    val pollochonOrange700 = Color(103, 50, 22)

    val pollochonRed50 = Color(254, 236, 237)
    val pollochonRed100 = Color(254, 201, 203)
    val pollochonRed200 = Color(253, 146, 151)
    val pollochonRed300 = Color(253, 114, 120)
    val pollochonRed400 = Color(227, 38, 47)
    val pollochonRed500 = Color(171, 0, 9)
    val pollochonRed600 = Color(135, 0, 7)
    val pollochonRed700 = Color(90, 0, 5)

    val pollochonWhite = Color(255, 255, 255)
    val pollochonGrey50 = Color(247, 248, 249)
    val pollochonGrey100 = Color(239, 241, 243)
    val pollochonGrey200 = Color(217, 221, 225)
    val pollochonGrey300 = Color(179, 186, 195)
    val pollochonGrey400 = Color(140, 150, 162)
    val pollochonGrey500 = Color(104, 119, 135)
    val pollochonGrey600 = Color(78, 93, 107)
    val pollochonGrey700 = Color(52, 68, 80)
    val pollochonGrey800 = Color(26, 42, 52)
    val pollochonGrey900 = Color(20, 33, 41)
    val pollochonBlack = Color(0, 16, 24)
}

val pollochonLightColorPalette = PollochonColors(
    pollochonBackgroundPrimary = PollochonPalette.pollochonWhite,
    pollochonBackgroundSecondary = PollochonPalette.pollochonGrey50,
    pollochonBackgroundBrandPrimary = PollochonPalette.pollochonBlue400,
    pollochonBackgroundAccent = PollochonPalette.pollochonYellow400,
    pollochonBackgroundPrimaryReversed = PollochonPalette.pollochonBlack,
    pollochonContentPrimary = PollochonPalette.pollochonBlack,
    pollochonContentTertiary = PollochonPalette.pollochonGrey500,
    pollochonContentAction = PollochonPalette.pollochonBlue500,
    pollochonContentNegative = PollochonPalette.pollochonRed400,
    pollochonContentWarning = PollochonPalette.pollochonOrange400,
    pollochonContentPositive = PollochonPalette.pollochonGreen400,
    pollochonContentInformation = PollochonPalette.pollochonBlue400,
    pollochonContentPrimaryReversed = PollochonPalette.pollochonWhite,
    pollochonBorderPrimary = PollochonPalette.pollochonGrey200,
    pollochonBorderActive = PollochonPalette.pollochonBlue400,
    pollochonBorderNegative = PollochonPalette.pollochonRed400,
    pollochonBorderWarning = PollochonPalette.pollochonOrange400,
    pollochonBorderPositive = PollochonPalette.pollochonGreen400,
    pollochonBorderPrimaryReversed = PollochonPalette.pollochonBlack,
    pollochonHoverPrimary = PollochonPalette.pollochonBlue50,
)

val pollochonDarkColorPalette = PollochonColors(
    pollochonBackgroundPrimary = PollochonPalette.pollochonGrey900,
    pollochonBackgroundSecondary = PollochonPalette.pollochonBlack,
    pollochonBackgroundBrandPrimary = PollochonPalette.pollochonBlue300,
    pollochonBackgroundAccent = PollochonPalette.pollochonYellow400,
    pollochonBackgroundPrimaryReversed = PollochonPalette.pollochonWhite,
    pollochonContentPrimary = PollochonPalette.pollochonWhite,
    pollochonContentTertiary = PollochonPalette.pollochonGrey300,
    pollochonContentAction = PollochonPalette.pollochonBlue200,
    pollochonContentNegative = PollochonPalette.pollochonRed300,
    pollochonContentWarning = PollochonPalette.pollochonOrange300,
    pollochonContentPositive = PollochonPalette.pollochonConifer300,
    pollochonContentInformation = PollochonPalette.pollochonBlue300,
    pollochonContentPrimaryReversed = PollochonPalette.pollochonBlack,
    pollochonBorderPrimary = PollochonPalette.pollochonGrey700,
    pollochonBorderActive = PollochonPalette.pollochonBlue300,
    pollochonBorderNegative = PollochonPalette.pollochonRed300,
    pollochonBorderWarning = PollochonPalette.pollochonOrange300,
    pollochonBorderPositive = PollochonPalette.pollochonConifer300,
    pollochonBorderPrimaryReversed = PollochonPalette.pollochonWhite,
    pollochonHoverPrimary = PollochonPalette.pollochonBlue700,
)

@OptIn(ExperimentalGraphicsApi::class)
@Stable
class PollochonColors constructor(
    // Background
    pollochonBackgroundPrimary: Color,
    pollochonBackgroundSecondary: Color,
    pollochonBackgroundBrandPrimary: Color,
    pollochonBackgroundAccent: Color,
    pollochonBackgroundPrimaryReversed: Color,

    // Content
    pollochonContentPrimary: Color,
    pollochonContentTertiary: Color,
    pollochonContentAction: Color,
    pollochonContentNegative: Color,
    pollochonContentWarning: Color,
    pollochonContentPositive: Color,
    pollochonContentInformation: Color,
    pollochonContentPrimaryReversed: Color,

    // Border
    pollochonBorderPrimary: Color,
    pollochonBorderActive: Color,
    pollochonBorderNegative: Color,
    pollochonBorderWarning: Color,
    pollochonBorderPositive: Color,
    pollochonBorderPrimaryReversed: Color,

    // Hover
    pollochonHoverPrimary: Color,

    // Active
    @Suppress("MagicNumber")
    pollochonActiveTertiary: Color = pollochonHoverPrimary.convertByHSL(lTransform = { it * 0.93f }),
) {
    var pollochonBackgroundPrimary by mutableStateOf(pollochonBackgroundPrimary)
        private set
    var pollochonBackgroundSecondary by mutableStateOf(pollochonBackgroundSecondary)
        private set
    var pollochonBackgroundBrandPrimary by mutableStateOf(pollochonBackgroundBrandPrimary)
        private set
    var pollochonBackgroundAccent by mutableStateOf(pollochonBackgroundAccent)
        private set
    var pollochonBackgroundPrimaryReversed by mutableStateOf(pollochonBackgroundPrimaryReversed)
        private set
    var pollochonContentPrimary by mutableStateOf(pollochonContentPrimary)
        private set
    var pollochonContentTertiary by mutableStateOf(pollochonContentTertiary)
        private set
    var pollochonContentAction by mutableStateOf(pollochonContentAction)
        private set
    var pollochonContentNegative by mutableStateOf(pollochonContentNegative)
        private set
    var pollochonContentWarning by mutableStateOf(pollochonContentWarning)
        private set
    var pollochonContentPositive by mutableStateOf(pollochonContentPositive)
        private set
    var pollochonContentInformation by mutableStateOf(pollochonContentInformation)
        private set
    var pollochonContentPrimaryReversed by mutableStateOf(pollochonContentPrimaryReversed)
        private set
    var pollochonBorderPrimary by mutableStateOf(pollochonBorderPrimary)
        private set
    var pollochonBorderActive by mutableStateOf(pollochonBorderActive)
        private set
    var pollochonBorderNegative by mutableStateOf(pollochonBorderNegative)
        private set
    var pollochonBorderWarning by mutableStateOf(pollochonBorderWarning)
        private set
    var pollochonBorderPositive by mutableStateOf(pollochonBorderPositive)
        private set
    var pollochonBorderPrimaryReversed by mutableStateOf(pollochonBorderPrimaryReversed)
        private set
    var pollochonActiveTertiary by mutableStateOf(pollochonActiveTertiary)
        private set

    fun update(other: PollochonColors) {
        pollochonBackgroundPrimary = other.pollochonBackgroundPrimary
        pollochonBackgroundPrimaryReversed = other.pollochonBackgroundPrimaryReversed
        pollochonContentPrimary = other.pollochonContentPrimary
        pollochonContentNegative = other.pollochonContentNegative
        pollochonContentWarning = other.pollochonContentWarning
        pollochonContentPositive = other.pollochonContentPositive
        pollochonContentInformation = other.pollochonContentInformation
        pollochonContentPrimaryReversed = other.pollochonContentPrimaryReversed
        pollochonBorderPrimary = other.pollochonBorderPrimary
        pollochonBorderNegative = other.pollochonBorderNegative
        pollochonBorderWarning = other.pollochonBorderWarning
        pollochonBorderPositive = other.pollochonBorderPositive
        pollochonBorderPrimaryReversed = other.pollochonBorderPrimaryReversed
    }
}

internal val LocalPollochonColors = compositionLocalOf<PollochonColors> {
    error("No PollochonColorPalette provided")
}

fun debugColors(
    darkTheme: Boolean,
    pollochonColors: PollochonColors
) = Colors(
    primary = pollochonColors.pollochonBackgroundBrandPrimary,
    primaryVariant = pollochonColors.pollochonBackgroundBrandPrimary,
    onPrimary = pollochonColors.pollochonContentPrimaryReversed,
    secondary = pollochonColors.pollochonBackgroundAccent,
    secondaryVariant = pollochonColors.pollochonBackgroundAccent,
    onSecondary = pollochonColors.pollochonContentPrimaryReversed,
    background = pollochonColors.pollochonBackgroundSecondary,
    onBackground = pollochonColors.pollochonContentPrimary,
    surface = pollochonColors.pollochonBackgroundPrimary,
    onSurface = pollochonColors.pollochonContentPrimary,
    error = pollochonColors.pollochonContentNegative,
    onError = pollochonColors.pollochonContentPrimaryReversed,
    isLight = !darkTheme
)

@ExperimentalGraphicsApi
fun Color.convertByHSL(
    hTransform: (h: Float) -> Float = { it },
    sTransform: (s: Float) -> Float = { it },
    lTransform: (l: Float) -> Float = { it },
    aTransform: (a: Float) -> Float = { it }
): Color {
    val (h, s, l) = this.toHSL()
    return Color.hsl(hTransform(h), sTransform(s), lTransform(l), aTransform(1f))
}

fun Color.toHSL(): HSLColor {
    val hsl = floatArrayOf(0f, 0f, 0f)
    @Suppress("MagicNumber")
    ColorUtils.RGBToHSL(
        (this.red * 255).toInt(),
        (this.green * 255).toInt(),
        (this.blue * 255).toInt(),
        hsl
    )
    return HSLColor(hsl[0], hsl[1], hsl[2])
}

@Immutable
data class HSLColor(
    val h: Float,
    val s: Float,
    val l: Float
)
