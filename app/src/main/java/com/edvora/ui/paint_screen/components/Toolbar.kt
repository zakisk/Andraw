package com.edvora.ui.paint_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.edvora.R
import com.edvora.ui.theme.LocalCustomShapes
import com.edvora.ui.theme.LocalSpacing
import com.edvora.util.Constants.ARROW
import com.edvora.util.Constants.ELLIPSE
import com.edvora.util.Constants.PENCIL
import com.edvora.util.Constants.RECTANGLE

@Composable
fun Toolbar(
    colorIconTint : MutableState<Color>,
    selected : MutableState<Int>,
    setColorIconTint : (Color) -> Unit,
    isShowColorBar: MutableState<Boolean>
) {

    val backgroundShape = LocalCustomShapes.current.backgroundShape

    val spacing = LocalSpacing.current

//    val columnModifier = if (isShowColorBar) Modifier.fillMaxWidth().fillMaxHeight(0.2f)
//                else Modifier.fillMaxWidth().fillMaxHeight(0.2f).padding(bottom = 44.dp)
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.15f),
        horizontalAlignment = Alignment.End
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = spacing.medium, start = spacing.medium, end = spacing.medium)
                .background(color = Color.LightGray.copy(0.5f), shape = backgroundShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val modifier = Modifier
                .background(color = Color.LightGray, shape = backgroundShape)
                .padding(spacing.extraSmall)

            IconButton(onClick = {
                selected.value = PENCIL
                isShowColorBar.value = false
            }) {
                DrawingIcon(
                    iconId = R.drawable.ic_edit,
                    modifier = if (selected.value == PENCIL) modifier else Modifier
                )
            }

            IconButton(onClick = {
                selected.value = ARROW
                isShowColorBar.value = false
            }) {
                DrawingIcon(
                    iconId = R.drawable.ic_arrow,
                    modifier = if (selected.value == ARROW) modifier else Modifier
                )
            }

            IconButton(onClick = {
                selected.value = RECTANGLE
                isShowColorBar.value = false
            }) {
                DrawingIcon(
                    iconId = R.drawable.ic_rectangle,
                    modifier = if (selected.value == RECTANGLE) modifier else Modifier
                )
            }

            IconButton(onClick = {
                selected.value = ELLIPSE
                isShowColorBar.value = false
            }) {
                DrawingIcon(
                    iconId = R.drawable.ic_ellipse,
                    modifier = if (selected.value == ELLIPSE) modifier else Modifier
                )
            }

            IconButton(onClick = { isShowColorBar.value = !isShowColorBar.value }) {
                DrawingIcon(
                    iconId = R.drawable.ic_color_lens,
                    tint = colorIconTint.value,
                    modifier = Modifier
                )
            }

        }

        if (isShowColorBar.value) {
            ColorBar(
                setColorIconTint = setColorIconTint,
                isShowColorBar = isShowColorBar
            )
        }

    }

}