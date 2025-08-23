package screen.property

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarProperty (
    val navBarItems: List<String> = emptyList(),
    val selectedNavBarItem: Int = 0,
    val selectedNavBarIcons: List<ImageVector> = emptyList(),
    val unselectedNavBarIcons: List<ImageVector> = emptyList(),
    val onNavBarItemSelected: (Int) -> Unit = {}
)