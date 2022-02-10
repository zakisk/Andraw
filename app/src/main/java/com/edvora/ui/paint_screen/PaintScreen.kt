package com.edvora.ui.paint_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.edvora.ui.paint_screen.components.PaintBody
import com.edvora.ui.paint_screen.components.Toolbar
import com.edvora.ui.paint_screen.model.PathState
import com.edvora.util.Constants

@ExperimentalComposeUiApi
@Composable
fun PaintScreen(viewModel: PaintViewModel) {

    val colorIconTint = remember { mutableStateOf(Color.Black) }

    val setColorIconTint: (Color) -> Unit = {
        colorIconTint.value = it
    }

    val isShowColorBar = remember { mutableStateOf(false) }

    val paths = remember { mutableStateOf(mutableListOf<PathState>()) }

    val selected = remember { mutableStateOf(Constants.PENCIL) }

    viewModel.paths.value.last().color = colorIconTint.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Toolbar(
            colorIconTint = colorIconTint,
            selected = selected,
            setColorIconTint = setColorIconTint,
            isShowColorBar = isShowColorBar
        )

        PaintBody(
            viewModel = viewModel,
            paths = paths,
            color = colorIconTint.value,
            type = selected.value,
            isShowColorBar = isShowColorBar
        )

    }
}

