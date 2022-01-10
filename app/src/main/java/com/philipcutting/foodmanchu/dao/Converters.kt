package com.philipcutting.foodmanchu.dao

import androidx.room.TypeConverter
import com.philipcutting.foodmanchu.models.Ingredient
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class Converters {
    @TypeConverter
    fun fromIngredientsJson(values: List<Ingredient>): String? {
        var listAsString = ""

        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<List<Ingredient>> = moshi.adapter(List::class.java as Class<List<Ingredient>>)
        val json = jsonAdapter.toJson(values)

        return json
//
//        values.forEach {ingredient ->
//            var item = "${ingredient.ingredientId},${ingredient.name},"
//            item += if (ingredient.isDeletable) {
//                "true"
//            } else {
//                "false"
//            }
//            item += ";"
//            listAsString += item
//        }
//        return listAsString
    }

    @TypeConverter
    fun toIngredientsFromJson(valuesJson: String) : List<Ingredient>? {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<List<Ingredient>> = moshi.adapter(List::class.java as Class<List<Ingredient>>)
        val list = jsonAdapter.fromJson(valuesJson)
        return list
    }

}