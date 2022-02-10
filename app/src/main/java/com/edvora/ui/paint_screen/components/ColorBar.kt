package com.edvora.ui.paint_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.edvora.ui.theme.LocalCustomShapes
import com.edvora.ui.theme.LocalSpacing

@Composable
fun ColorBar(
    setColorIconTint: (Color) -> Unit,
    isShowColorBar: MutableState<Boolean>
) {

    val backgroundShape = LocalCustomShapes.current.backgroundShape

    val spacing = LocalSpacing.current

    Row(
        modifier = Modifier
            .padding(top = spacing.extraSmall, end = spacing.medium)
            .background(color = Color.LightGray.copy(0.5f), shape = backgroundShape),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        ColorBox(
            color = Color.Red,
            setColorIconTint = setColorIconTint,
            isShowColorBar = isShowColorBar
        )
        ColorBox(
            color = Color.Green,
            setColorIconTint = setColorIconTint,
            isShowColorBar = isShowColorBar
        )
        ColorBox(
            color = Color.Blue,
            setColorIconTint = setColorIconTint,
            isShowColorBar = isShowColorBar
        )
        ColorBox(
            color = Color.Black,
            setColorIconTint = setColorIconTint,
            isShowColorBar = isShowColorBar
        )

    }

}