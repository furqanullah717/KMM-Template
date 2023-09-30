package com.codewithfk.eventhub.core.presentation


import com.codewithfk.eventhub.di.AppModule
import com.codewithfk.eventhub.event.App
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = PreComposeApplication() {
    val isDarkTheme =
        UIScreen.mainScreen.traitCollection.userInterfaceStyle ==
                UIUserInterfaceStyle.UIUserInterfaceStyleDark
    App(
        darkTheme  = isDarkTheme,
        dynamicColor = false,
        appModule = AppModule(),
    )
}