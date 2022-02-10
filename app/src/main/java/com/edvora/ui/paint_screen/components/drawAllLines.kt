package com.edvora.ui.paint_screen.components

import android.view.MotionEvent
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import com.edvora.ui.paint_screen.model.PathState


fun drawAllLines(
    event: MotionEvent,
    paths : MutableState<MutableList<PathState>>,
    lastPath : MutableState<Offset?>
) {

    val currentPath = paths.value.last()

    val current = Offset(
        if (event.x < 0f) 0f else event.x,
        if (event.y < 0f) 0f else event.y
    )

    when(event.action) {
        MotionEvent.ACTION_DOWN -> {
            currentPath.path.moveTo(current.x, current.y)
        }

        MotionEvent.ACTION_MOVE -> {
            lastPath.value = current
            currentPath.path.lineTo(current.x, current.y)
        }

        MotionEvent.ACTION_UP -> {
            lastPath.value = current
        }
    }

}