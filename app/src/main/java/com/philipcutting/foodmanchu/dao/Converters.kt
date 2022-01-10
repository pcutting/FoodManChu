package com.philipcutting.foodmanchu.dao

import androidx.room.TypeConverter
import com.philipcutting.foodmanchu.models.Ingredient

class Converters {
    @TypeConverter
    fun fromIngredients(values: List<Ingredient>): String? {
        var listAsString = ""

        values.forEach {ingredient ->
            var item = "${ingredient.ingredientId},${ingredient.name},"
            item += if (ingredient.isDeletable) {
                "true"
            } else {
                "false"
            }
            item += ";"
            listAsString += item
        }
        return listAsString
    }
}