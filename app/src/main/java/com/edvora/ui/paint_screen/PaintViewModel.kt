package com.edvora.ui.paint_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.lifecycle.ViewModel
import com.edvora.ui.paint_screen.model.ArrowState
import com.edvora.ui.paint_screen.model.EllipseState
import com.edvora.ui.paint_screen.model.PathState
import com.edvora.ui.paint_screen.model.RectangleState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaintViewModel @Inject constructor() : ViewModel() {

    val paths : MutableState<MutableList<PathState>> = mutableStateOf(mutableListOf())

    val arrows: MutableState<MutableList<ArrowState>> = mutableStateOf(mutableListOf())

    val rectangles: MutableState<MutableList<RectangleState>> = mutableStateOf(mutableListOf())

    val ellipses: MutableState<MutableList<EllipseState>> = mutableStateOf(mutableListOf())

    val startOffset: MutableState<Offset> = mutableStateOf(Offset.Zero)

    val  lineLastPath: MutableState<Offset?> = mutableStateOf(null)

    val  arrowLastPath: MutableState<Offset?> = mutableStateOf(null)

    val  rectangleLastPath: MutableState<Offset?> = mutableStateOf(null)

    val  ellipseLastPath: MutableState<Offset?> = mutableStateOf(null)

}