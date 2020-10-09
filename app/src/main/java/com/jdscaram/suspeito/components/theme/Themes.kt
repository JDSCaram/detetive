package com.jdscaram.suspeito.components.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.jdscaram.suspeito.core.ext.compose.ComposableFn

@Composable
fun DetectiveTheme(
    content: ComposableFn,
) {
    MaterialTheme(
        colors = DetectiveLightPalette,
        content = content
    )
}
