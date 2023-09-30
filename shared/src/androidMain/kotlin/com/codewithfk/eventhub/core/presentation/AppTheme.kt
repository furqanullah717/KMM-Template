package com.codewithfk.eventhub.core.presentation

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.codewithfk.eventhub.theme.DarkColors
import com.codewithfk.eventhub.theme.LightColors
import com.codewithfk.eventhub.theme.Typography

@Composable
actual fun AppTheme(isDarkMode: Boolean, content: @Composable () -> Unit) {
    val colorScheme = when {
        isDarkMode -> DarkColors
        else -> LightColors
    }

    val view = LocalView.current
    if(!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(
                window,
                view
            ).isAppearanceLightStatusBars = isDarkMode
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}