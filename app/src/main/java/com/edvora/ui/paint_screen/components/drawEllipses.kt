package com.edvora.ui.paint_screen.components

import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.edvora.ui.paint_screen.model.EllipseState

fun DrawScope.drawEllipses(
    ellipses : MutableState<MutableList<EllipseState>>,
    ellipseLastPath: MutableState<Offset?>
) {
    ellipseLastPath.value?.let {
        ellipses.value.forEach {
            drawOval(
                color = it.color,
                topLeft = it.topLeft,
                size = it.size,
                style = Stroke(5f)
            )
        }
    }


}