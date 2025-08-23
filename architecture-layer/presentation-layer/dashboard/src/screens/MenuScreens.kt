package screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.ui.graphics.vector.ImageVector

enum class MenuScreens(
    val title: String,
    val id: Int,
    val selectedIcons: ImageVector,
    val unselectedIcons: ImageVector
) {
    HOME("Home", 0, Icons.Filled.Home, Icons.Outlined.Home),
    PROFILE("Profile", 1, Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder),
    SETTINGS("Settings", 2, Icons.Filled.Star, Icons.Outlined.StarBorder),
}