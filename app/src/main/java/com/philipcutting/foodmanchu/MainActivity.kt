package com.philipcutting.foodmanchu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.philipcutting.foodmanchu.dao.FoodeDatabase

class MainActivity : AppCompatActivity() {

    private var database: FoodeDatabase? = null
    //TODO
    // https://youtu.be/vsDkhRTMdA0?t=309
    //Consider this for making singleton structure for database instead of putting it into the mainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            applicationContext,
            FoodeDatabase::class.java,
            "food_man_chu_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    override fun onResume() {
        super.onResume()
        val recipes = database?.recipeDao()?.getAll()
        val ingredients = database?.ingredientDao()?.getAll()
    }
}