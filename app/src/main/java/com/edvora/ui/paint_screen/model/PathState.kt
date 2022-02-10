package com.edvora.ui.paint_screen.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

data class PathState(
    var path : Path,
    var color : Color,
    val stroke : Float = 5f
)
