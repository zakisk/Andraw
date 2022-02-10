package com.edvora.ui.paint_screen.components

import android.view.MotionEvent
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.edvora.ui.paint_screen.model.ArrowState

fun drawAllArrows(
    event: MotionEvent,
    arrows: MutableState<MutableList<ArrowState>>,
    lastPath: MutableState<Offset?>,
    startOffset: MutableState<Offset>,
    color : Color
) {
    val current = Offset(
        if (event.x < 0f) 0f else event.x,
        if (event.y < 0f) 0f else event.y
    )

    when (event.action) {
        MotionEvent.ACTION_DOWN -> {
            startOffset.value = current
        }
        MotionEvent.ACTION_MOVE -> {
            lastPath.value = current
            arrows.value.removeLastOrNull()
            arrows.value.add(
                ArrowState(
                    color = color,
                    from = startOffset.value,
                    to = current
                )
            )
        }
        MotionEvent.ACTION_UP -> {
            lastPath.value = current
            arrows.value.add(
                ArrowState(
                    color = color,
                    from = startOffset.value,
                    to = current
                )
            )
        }
    }
}