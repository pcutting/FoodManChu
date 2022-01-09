package com.philipcutting.foodmanchu.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ingredients")
data class Ingredient(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name= "ingredient_id") val ingredientId: Int,
    @ColumnInfo(name = "ingredient_name" ) var name: String,
    @ColumnInfo(name = "is_deletable" )var isDeletable: Boolean = false
)
