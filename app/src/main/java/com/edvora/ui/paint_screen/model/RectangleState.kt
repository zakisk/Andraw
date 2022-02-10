package com.edvora.ui.paint_screen.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class RectangleState(
    val start : Offset,
    val end : Offset,
    val color : Color
)
