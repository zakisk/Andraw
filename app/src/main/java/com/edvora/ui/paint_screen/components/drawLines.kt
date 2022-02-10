package com.edvora.ui.paint_screen.components


import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.edvora.ui.paint_screen.model.PathState

fun DrawScope.drawLines(
    paths : MutableState<MutableList<PathState>>,
    lastPath : MutableState<Offset?>,
    color : Color
) {

    val linePath = paths.value.last()

    lastPath.value?.let { offset ->
        linePath.path.moveTo(offset.x, offset.y)
        drawPath(
            path = linePath.path,
            color = linePath.color,
            style = Stroke(5f)
        )

        paths.value.forEach {
            drawPath(
                path = it.path,
                color = it.color,
                style = Stroke(5f)
            )
        }
    }


}