package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.example.app.ui.theme.RecipeExplorerTheme
import org.example.app.ui.screens.HomeScreen
import org.example.app.ui.screens.SearchScreen
import org.example.app.ui.screens.FavoritesScreen

// PUBLIC_INTERFACE
class MainActivity : ComponentActivity() {
    /**
     * The main Activity entrypoint, hosts the composable UI and bottom navigation.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeExplorerTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * The main UI wrapper, displaying a bottom navigation bar with Home, Search, and Favorites.
 */
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(BottomNavTab.HOME) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavTab.entries.forEach { tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) },
                        selected = tab == selectedTab,
                        onClick = { selectedTab = tab }
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedTab) {
            BottomNavTab.HOME -> HomeScreen(Modifier.padding(innerPadding))
            BottomNavTab.SEARCH -> SearchScreen(Modifier.padding(innerPadding))
            BottomNavTab.FAVORITES -> FavoritesScreen(Modifier.padding(innerPadding))
        }
    }
}

enum class BottomNavTab(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    HOME("Home", Icons.Filled.Home),
    SEARCH("Search", Icons.Filled.Search),
    FAVORITES("Favorites", Icons.Filled.Favorite)
}
