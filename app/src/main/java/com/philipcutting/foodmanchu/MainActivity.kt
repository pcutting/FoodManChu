package com.philipcutting.foodmanchu

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.philipcutting.foodmanchu.dao.FoodeDatabase
import com.philipcutting.foodmanchu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var database: FoodeDatabase? = null
    //TODO
    // https://youtu.be/vsDkhRTMdA0?t=309
    //Consider this for making singleton structure for database instead of putting it into the mainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            FoodeDatabase::class.java,
            "food_man_chu_db"
        ).fallbackToDestructiveMigration()
            .build()


        binding.bottomNavigationBar.setOnItemSelectedListener {item ->
            when(item.itemId) {
                R.id.ingredients_menu -> {

                    true
                }
                else -> false
            }
        }

    }


    override fun onResume() {
        super.onResume()
        AsyncTask.execute {
            val recipes = database?.recipeDao()?.getAll()
            val ingredients = database?.ingredientDao()?.getAll()
        }
    }
}