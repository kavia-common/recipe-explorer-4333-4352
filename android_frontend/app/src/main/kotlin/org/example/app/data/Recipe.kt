package org.example.app.data

// PUBLIC_INTERFACE
data class Recipe(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val shortDescription: String? = null,
    val ingredients: List<String> = emptyList(),
    val instructions: List<String> = emptyList(),
    val isFavorite: Boolean = false
)

val fakeRecipeList = listOf(
    Recipe(
        1,
        "Spaghetti Bolognese",
        "https://images.pexels.com/photos/1279330/pexels-photo-1279330.jpeg",
        "Classic meat sauce over spaghetti",
        listOf("Spaghetti", "Ground beef", "Tomato sauce", "Onion"),
        listOf("Cook pasta", "Sauté beef", "Add sauce", "Combine and serve")
    ),
    Recipe(
        2,
        "Caprese Salad",
        "https://images.pexels.com/photos/1437267/pexels-photo-1437267.jpeg",
        "Fresh mozzarella, tomatoes, and basil",
        listOf("Tomato", "Mozzarella", "Basil", "Olive Oil"),
        listOf("Slice tomato & mozzarella", "Arrange with basil", "Drizzle oil"),
        isFavorite = true
    ),
    Recipe(
        3,
        "Tacos",
        "https://images.pexels.com/photos/461382/pexels-photo-461382.jpeg",
        "Tortillas with savory fillings",
        listOf("Tortilla", "Meat/beans", "Cheese", "Lettuce"),
        listOf("Prepare fillings", "Heat tortillas", "Assemble tacos")
    )
)
