package com.edvora.ui.paint_screen.components

import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.edvora.ui.paint_screen.model.ArrowState

fun DrawScope.drawArrows(
    arrows: MutableState<MutableList<ArrowState>>,
    arrowLastPath: MutableState<Offset?>
) {
    arrowLastPath.value?.let {
        arrows.value.forEach {
            drawLine(
                color = it.color,
                start = it.from,
                end = it.to,
                strokeWidth = 5f,
                cap = StrokeCap.Butt
            )

            drawOval(
                color = it.color,
                topLeft = Offset(it.to.x - 10f, it.to.y - 10f),
                size = Size(20f, 20f)
            )
        }
    }
}