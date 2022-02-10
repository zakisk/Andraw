package com.edvora.ui.theme

import androidx.compose.runtime.Composable

@Composable
fun MyApp(content : @Composable () -> Unit) {
    EdvoraTheme {
        content()
    }
}