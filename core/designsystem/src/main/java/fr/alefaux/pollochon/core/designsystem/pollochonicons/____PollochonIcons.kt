package fr.alefaux.pollochon.core.designsystem.pollochonicons

import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.AllAssets
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import kotlin.collections.List as ____KtList

public object PollochonIcons

private var __AllAssets: ____KtList<ImageVector>? = null

public val PollochonIcons.AllAssets: ____KtList<ImageVector>
    get() {
        if (__AllAssets != null) {
            return __AllAssets!!
        }
        __AllAssets= Line.AllAssets + listOf()
        return __AllAssets!!
    }