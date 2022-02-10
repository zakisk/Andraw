package com.edvora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.edvora.ui.paint_screen.PaintScreen
import com.edvora.ui.paint_screen.PaintViewModel
import com.edvora.ui.paint_screen.model.PathState
import com.edvora.ui.theme.MyApp
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : PaintViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }


    @Composable
    fun MainScreen() {
        viewModel.paths.value.add(PathState(Path(), Color.Black))
        PaintScreen(viewModel = viewModel)
    }
}