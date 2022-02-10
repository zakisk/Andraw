package com.edvora.util

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

infix fun Offset.subtract(other : Offset) : Size {
    return Size(this.x - other.x, this.y - other.y)
}

fun Context.showToast(message : String) {
    MainScope().launch {
        Toast.makeText(this@showToast, message, Toast.LENGTH_LONG).show()
    }
}
