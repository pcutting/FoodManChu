package com.philipcutting.foodmanchu.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name= "recipe_id") val recipeId: Int,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "instructions") var instructions: String,
    @ColumnInfo(name = "minutes_to_prepare") var prepTimeInMinutes: Int,
    @ColumnInfo(name = "ingredients") var ingredients: MutableList<Ingredient> = mutableListOf(),
    @ColumnInfo(name = "category") var category:RecipeCategory
)

enum class RecipeCategory(val label:String) {
    MEAT("meat"),
    VEGAN("vegan"),
    KETO("keto"),
    PALEO("palio"),
    ETHNIC("ethnic"),
    SOUL("soul"),
    HOLIDAY("holiday"),
    OTHER("other");
}