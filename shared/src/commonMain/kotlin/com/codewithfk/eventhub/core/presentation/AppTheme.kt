package com.codewithfk.eventhub.core.presentation

import androidx.compose.runtime.Composable
@Composable
expect fun AppTheme(isDarkMode:Boolean ,content: @Composable () -> Unit)