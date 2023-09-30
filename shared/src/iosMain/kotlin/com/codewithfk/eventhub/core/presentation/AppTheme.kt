package com.codewithfk.eventhub.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.codewithfk.eventhub.theme.DarkColors
import com.codewithfk.eventhub.theme.LightColors
import com.codewithfk.eventhub.theme.Typography


@Composable
actual fun AppTheme(isDarkMode: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isDarkMode) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}