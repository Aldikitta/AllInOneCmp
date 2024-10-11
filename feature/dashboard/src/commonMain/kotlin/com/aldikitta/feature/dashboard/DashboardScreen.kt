package com.aldikitta.feature.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.aldikitta.feature.dashboard.components.GridMenu
import com.aldikitta.feature.dashboard.components.ItemMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit,
    navigateToDynamicForm: () -> Unit,
    navigateToDsl: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        }
    ) {
        GridMenu(
            paddingValues = it,
            itemsMenu = listOf(
                ItemMenu(
                    title = "Movie",
                    icon = Icons.Default.Movie,
                    navigateTo = navigateToMovie
                ),
                ItemMenu(
                    title = "E-Commerce",
                    icon = Icons.Default.Shop,
                    navigateTo = navigateToEcommerce
                ),
                ItemMenu(
                    title = "Dynamic Form",
                    icon = Icons.Default.DynamicForm,
                    navigateTo = navigateToDynamicForm
                ),
                ItemMenu(
                    title = "DSL",
                    icon = Icons.Default.DesignServices,
                    navigateTo = navigateToDsl
                ),
                ItemMenu(
                    title = "CMP Playground",
                    icon = Icons.Default.Settings,
                    navigateTo = navigateToCmpPlayground
                ),
            )
        )
    }
}