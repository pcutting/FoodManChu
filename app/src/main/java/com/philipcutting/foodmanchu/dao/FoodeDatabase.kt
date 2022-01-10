package com.philipcutting.foodmanchu.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.philipcutting.foodmanchu.models.Ingredient
import com.philipcutting.foodmanchu.models.Recipe

@Database(entities = [Ingredient::class, Recipe::class], version = 1)
abstract class FoodeDatabase : RoomDatabase() {
    abstract fun ingredientDao() : IngredientDao
    abstract fun recipeDao(): RecipeDao
}