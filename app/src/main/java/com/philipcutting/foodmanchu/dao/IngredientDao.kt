package com.philipcutting.foodmanchu.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.philipcutting.foodmanchu.models.Ingredient

interface IngredientDao {
    @Query("SELECT * FROM ingredients")
    fun getAll(): List<Ingredient>

    @Query("SELECT * FROM ingredients WHERE ingredient_id IN (:ingredientIds)")
    fun loadAllByIDs(ingredientIds: IntArray): List<Ingredient>

    @Query("Select * FROM ingredients WHERE ingredient_name LIKE :name LIMIT 1")
    fun findByName(name:String): Ingredient

    @Insert
    fun insertAll(vararg ingredients: Ingredient)

    @Delete
    fun delete(ingredient: Ingredient)
}