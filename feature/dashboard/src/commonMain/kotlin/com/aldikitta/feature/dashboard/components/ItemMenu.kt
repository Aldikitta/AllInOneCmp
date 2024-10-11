package com.aldikitta.feature.dashboard.components

import androidx.compose.ui.graphics.vector.ImageVector

data class ItemMenu(
    val title: String,
    val icon: ImageVector,
    val navigateTo: () -> Unit
)