package com.edvora.ui.paint_screen.components

import android.view.MotionEvent
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.edvora.ui.paint_screen.model.EllipseState
import com.edvora.util.subtract

fun drawAllEllipses(
    event: MotionEvent,
    ellipses : MutableState<MutableList<EllipseState>>,
    lastPath : MutableState<Offset?>,
    startOffset : MutableState<Offset>,
    color: Color
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
            ellipses.value.removeLastOrNull()
            ellipses.value.add(
                EllipseState(
                    color = color,
                    topLeft = startOffset.value,
                    size = current subtract startOffset.value
                )
            )
        }

        MotionEvent.ACTION_UP -> {
            lastPath.value = current
            ellipses.value.add(
                EllipseState(
                    color = color,
                    topLeft = startOffset.value,
                    size = current subtract startOffset.value
                )
            )
        }
    }
}