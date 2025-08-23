package screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.DynamicForm
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shop
import androidx.compose.runtime.Composable
import components.GridMenu
import components.ItemMenu

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit,
    navigateToDynamicForm: () -> Unit,
    navigateToDsl: () -> Unit,
) {
    GridMenu(
        paddingValues = paddingValues,
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