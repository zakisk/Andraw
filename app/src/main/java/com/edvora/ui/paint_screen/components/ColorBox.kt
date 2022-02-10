package com.edvora.ui.paint_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.edvora.ui.theme.LocalCustomShapes
import com.edvora.ui.theme.LocalSpacing

@Composable
fun ColorBox(
    color : Color,
    setColorIconTint : (Color) -> Unit,
    isShowColorBar : MutableState<Boolean>
) {
    val backgroundShape = LocalCustomShapes.current.backgroundShape

    val spacing = LocalSpacing.current.extraSmall

    Box(
        modifier = Modifier.size(32.dp)
            .padding(spacing)
            .background(color = color, shape = backgroundShape)
            .clickable {
                setColorIconTint(color)
                isShowColorBar.value = false
            }
    ) {}
}