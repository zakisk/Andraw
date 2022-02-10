package com.edvora.ui.paint_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.edvora.ui.paint_screen.PaintViewModel
import com.edvora.ui.paint_screen.model.PathState
import com.edvora.util.Constants.ARROW
import com.edvora.util.Constants.ELLIPSE
import com.edvora.util.Constants.PENCIL
import com.edvora.util.Constants.RECTANGLE

@ExperimentalComposeUiApi
@Composable
fun PaintBody(
    viewModel: PaintViewModel,
    paths : MutableState<MutableList<PathState>>,
    color: Color,
    type: Int,
    isShowColorBar: MutableState<Boolean>
) {

    paths.value.add(PathState(Path(), color))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                isShowColorBar.value = false
            }
            .pointerInteropFilter { event ->

                when (type) {
                    PENCIL -> {
                        drawAllLines(
                            event = event,
                            paths = paths,
                            lastPath = viewModel.lineLastPath
                        )
                    }

                    ARROW -> {
                        drawAllArrows(
                            event = event,
                            arrows = viewModel.arrows,
                            lastPath = viewModel.arrowLastPath,
                            startOffset = viewModel.startOffset,
                            color = color
                        )
                    }

                    RECTANGLE -> {
                        drawAllRectangle(
                            event = event,
                            rectangles = viewModel.rectangles,
                            lastPath = viewModel.rectangleLastPath,
                            startOffset = viewModel.startOffset,
                            color = color
                        )
                    }

                    ELLIPSE -> {
                        drawAllEllipses(
                            event = event,
                            ellipses = viewModel.ellipses,
                            lastPath = viewModel.ellipseLastPath,
                            startOffset = viewModel.startOffset,
                            color = color
                        )
                    }
                }
                true
            }
            .drawBehind {

                drawLines(
                    paths = paths,
                    lastPath = viewModel.lineLastPath,
                    color = color
                )

                drawRectangles(
                    rectangles = viewModel.rectangles,
                    rectanglesLastPath = viewModel.rectangleLastPath
                )

                drawEllipses(
                    ellipses = viewModel.ellipses,
                    ellipseLastPath = viewModel.ellipseLastPath
                )

                drawArrows(
                    arrows = viewModel.arrows,
                    arrowLastPath = viewModel.arrowLastPath
                )

            }
    ) { }

}