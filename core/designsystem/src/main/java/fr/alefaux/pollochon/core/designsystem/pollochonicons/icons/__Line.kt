package fr.alefaux.pollochon.core.designsystem.pollochonicons.icons

import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.Check
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.ErrorWarning
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.Share
import kotlin.collections.List as ____KtList

public object LineGroup

public val PollochonIcons.Line: LineGroup
    get() = LineGroup

private var __AllAssets: ____KtList<ImageVector>? = null

public val LineGroup.AllAssets: ____KtList<ImageVector>
    get() {
        if (__AllAssets != null) {
            return __AllAssets!!
        }
        __AllAssets = listOf(Check, ErrorWarning, Share)
        return __AllAssets!!
    }