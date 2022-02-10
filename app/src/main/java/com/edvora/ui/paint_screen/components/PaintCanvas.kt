package com.edvora.ui.paint_screen.components

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import com.edvora.ui.paint_screen.model.PathState

@ExperimentalComposeUiApi
@Composable
fun PaintCanvas(
    drawColor: Color,
    drawBrush: Float
) {
    val paths by remember { mutableStateOf(mutableListOf<PathState>()) }

    paths.add(PathState(Path(), drawColor))

    val currentPath = paths.last().path
    val lastPath = remember { mutableStateOf<Offset?>(null) }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
//                        currentPath.moveTo(it.x, it.y)
                    }

                    MotionEvent.ACTION_MOVE -> {
//                        lastPath.value = Offset(it.x, it.y)
                    }

                    MotionEvent.ACTION_UP -> {
//                        currentPath.moveTo(it.x, it.y)
                    }
                }
                true
            }
    ) {



            currentPath.addArc(
                oval = Rect(
                    topLeft = Offset(0f, 0f),
                    bottomRight = Offset(300f, 200f)
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 360f
            )

        drawPath(
                path = currentPath,
                color = drawColor,
                style = Stroke(drawBrush)
            )

//        movePath.value?.let {
//            currentPath.lineTo(it.x, it.y)
//            currentPath.addArc(
//                oval = Rect(
//                    topLeft = Offset(it.x, it.y),
//                    bottomRight = Offset(it.x + 200f, it.y + 100f)
//                ),
//                startAngleDegrees = 0f,
//                sweepAngleDegrees = 360f
//            )
//
//            drawPath(
//                path = currentPath,
//                color = drawColor,
//                style = Stroke(drawBrush)
//            )
//        }
//        paths.forEach {
//            drawPath(
//                path = it.path,
//                color = it.color,
//                style = Stroke(it.stroke)
//            )
//        }
    }

}