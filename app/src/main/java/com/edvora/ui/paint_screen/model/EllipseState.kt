package com.edvora.ui.paint_screen.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

data class EllipseState(
    val color: Color,
    val topLeft : Offset,
    val size : Size
)
