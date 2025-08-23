import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import components.GridMenu
import components.ItemMenu
import screen.CmpIsFunScreen
import screen.CmpIsFunScreenViewModel
import screen.property.NavigationBarProperty
import screens.HomeScreen
import screens.MenuScreens

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
    val items = listOf(MenuScreens.HOME, MenuScreens.PROFILE, MenuScreens.SETTINGS)
    var selectedNavBarItem by remember { mutableIntStateOf(MenuScreens.HOME.id) }

    CmpIsFunScreen(
        titleTopBar = "Dashboard",
        navigationBarProperty = NavigationBarProperty(
            navBarItems = items.map { it.title },
            selectedNavBarItem = selectedNavBarItem,
            selectedNavBarIcons = items.map { it.selectedIcons },
            unselectedNavBarIcons = items.map { it.unselectedIcons },
            onNavBarItemSelected = { index -> selectedNavBarItem = index },
        ),
        content = { paddingValues ->
            when (items[selectedNavBarItem]) {
                MenuScreens.HOME -> {
                    HomeScreen(
                        paddingValues = paddingValues,
                        navigateToMovie = navigateToMovie,
                        navigateToEcommerce = navigateToEcommerce,
                        navigateToCmpPlayground = navigateToCmpPlayground,
                        navigateToDynamicForm = navigateToDynamicForm,
                        navigateToDsl = navigateToDsl,
                    )
                }
                MenuScreens.PROFILE -> {
                    // ProfileScreen(paddingValues)
                }
                MenuScreens.SETTINGS -> {
                    // SettingsScreen(paddingValues)
                }
            }
        }
    )
}