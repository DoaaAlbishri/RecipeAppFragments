package com.example.recipeappfragments.dataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM Recipe")
    fun getRecipe(): LiveData<List<RecipeDetails>>

    @Insert
    fun insertRecipe(recipe: RecipeDetails)

    @Delete
    fun deleteRecipe(recipe: RecipeDetails)

    @Update
    fun updateRecipe(recipe: RecipeDetails)
}