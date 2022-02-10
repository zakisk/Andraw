package com.edvora.ui.paint_screen.components

import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.edvora.ui.paint_screen.model.RectangleState
import com.edvora.util.subtract

fun DrawScope.drawRectangles(
    rectangles : MutableState<MutableList<RectangleState>>,
    rectanglesLastPath: MutableState<Offset?>
) {
    rectanglesLastPath.value?.let {
        rectangles.value.forEach {
            drawRect(
                color = it.color,
                topLeft = it.start,
                size = it.end subtract it.start,
                style = Stroke(width = 5f)
            )
        }
    }
}