import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import components.GridMenu
import components.ItemMenu
import screen.CmpIsFunScreen
import screen.CmpIsFunScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit,
    navigateToDynamicForm: () -> Unit,
    navigateToDsl: () -> Unit,
) {
    CmpIsFunScreen(
        titleTopBar = "Dashboard",
        content = { paddingValues ->
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
    )
}