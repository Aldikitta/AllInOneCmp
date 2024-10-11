package com.aldikitta.feature.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.aldikitta.feature.dashboard.components.Grid
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
        Grid(
            paddingValues = it,
            itemsMenu = listOf(
                ItemMenu(
                    title = "Movie",
                    icon = Icons.Default.Movie,
                    navigteTo = navigateToMovie
                ),
                ItemMenu(
                    title = "E-Commerce",
                    icon = Icons.Default.Shop,
                    navigteTo = navigateToEcommerce
                ),
                ItemMenu(
                    title = "Dynamic Form",
                    icon = Icons.Default.DynamicForm,
                    navigteTo = navigateToDynamicForm
                ),
                ItemMenu(
                    title = "DSL",
                    icon = Icons.Default.DesignServices,
                    navigteTo = navigateToDsl
                ),
                ItemMenu(
                    title = "CMP Playground",
                    icon = Icons.Default.Settings,
                    navigteTo = navigateToCmpPlayground
                ),
            )
        )
    }
}