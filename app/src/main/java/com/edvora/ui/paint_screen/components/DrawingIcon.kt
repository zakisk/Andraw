package com.edvora.ui.paint_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun DrawingIcon(
    @DrawableRes iconId : Int,
    tint : Color = Color.Unspecified,
    modifier : Modifier
) {

    Icon(
        painter = painterResource(id = iconId),
        contentDescription = null,
        tint = tint,
        modifier = modifier.clipToBounds()
    )
}