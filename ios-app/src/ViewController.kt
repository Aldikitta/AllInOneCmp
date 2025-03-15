package com.aldikitta.allinonecmp

import App
import androidx.compose.ui.window.ComposeUIViewController
import di.KoinInitializer

fun ViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
){ App() }