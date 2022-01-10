package com.philipcutting.foodmanchu.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.philipcutting.foodmanchu.models.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAll(): List<Recipe>
    //try: min 3 https://www.youtube.com/watch?v=vsDkhRTMdA0
    //fun getAll(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE recipe_id IN (:recipesIds)")
    fun loadAllByIDs(recipesIds: IntArray): List<Recipe>

    @Query("Select * FROM recipes WHERE name LIKE :name LIMIT 1")
    fun findByName(name:String): Recipe

    @Insert
    fun insertAll(vararg recipes: Recipe)

    @Insert
    fun insert(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}