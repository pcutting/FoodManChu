package com.philipcutting.foodmanchu.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor
import java.time.ZoneId

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val recipeId: Int,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "instructions") var instructions: String,
    @ColumnInfo(name = "minutes_to_prepare") var prepTimeInMinutes: Int,
    @ColumnInfo(name = "ingredients") var ingredients: MutableList<Ingredient> = mutableListOf<Ingredient>(),
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