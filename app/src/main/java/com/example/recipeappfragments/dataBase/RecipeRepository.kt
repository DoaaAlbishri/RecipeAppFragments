package com.example.recipeappfragments.dataBase

import androidx.lifecycle.LiveData

class RecipeRepository( private val recipeDao : RecipeDao) {
    val getRecipe : LiveData<List<RecipeDetails>> = recipeDao.getRecipe()

    suspend fun addRecipe(recipe : RecipeDetails){
        recipeDao.insertRecipe(
                RecipeDetails(recipe.id,
                        recipe.title,
                        recipe.author,
                        recipe.ingredients,
                        recipe.instructions)
        )
    }
    suspend fun updateRecipe(recipe : RecipeDetails){
        recipeDao.updateRecipe(
                RecipeDetails(recipe.id,
                        recipe.title,
                        recipe.author,
                        recipe.ingredients,
                        recipe.instructions)
        )
    }
    suspend fun deleteRecipe(recipe : RecipeDetails){
        recipeDao.deleteRecipe(
                RecipeDetails(recipe.id,
                        recipe.title,
                        recipe.author,
                        recipe.ingredients,
                        recipe.instructions)
        )
    }
}