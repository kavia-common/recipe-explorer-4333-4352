package org.example.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.app.data.Recipe
import org.example.app.data.fakeRecipeList
import org.example.app.ui.widgets.RecipeCard

// PUBLIC_INTERFACE
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    val recipes = remember { fakeRecipeList }
    val filtered = if (query.isBlank()) recipes else recipes.filter {
        it.title.contains(query, ignoreCase = true)
    }
    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Search Recipes") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(filtered.size) { idx ->
                RecipeCard(recipe = filtered[idx])
            }
        }
    }
}
