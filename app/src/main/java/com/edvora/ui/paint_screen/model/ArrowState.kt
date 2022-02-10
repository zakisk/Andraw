package com.edvora.ui.paint_screen.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class ArrowState(
    val color: Color,
    val from : Offset,
    val to : Offset
)
