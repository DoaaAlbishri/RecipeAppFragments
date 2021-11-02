package com.example.recipeappviewmodel.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeappfragments.dataBase.RecipeDatabase
import com.example.recipeappfragments.dataBase.RecipeDetails
import com.example.recipeappfragments.dataBase.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel (applicationContext : Application): AndroidViewModel(applicationContext)  {
    private val recipes: LiveData<List<RecipeDetails>>
    private val repository : RecipeRepository

    init {
        val recipeDao = RecipeDatabase.getInstance(applicationContext).RecipeDao()
        repository = RecipeRepository(recipeDao)
        recipes = repository.getRecipe
    }

    fun getRecipes(): LiveData<List<RecipeDetails>>{
        return recipes
    }

    fun addRecipe(r: RecipeDetails){
        CoroutineScope(Dispatchers.IO).launch {
            val recipe = RecipeDetails(r.id,
                    r.title,
                    r.author,
                    r.ingredients,
                    r.instructions)
            repository.addRecipe(recipe)
            println("added")
        }
    }

    fun updateRecipe(r: RecipeDetails){
        CoroutineScope(Dispatchers.IO).launch {
            val recipe = RecipeDetails(r.id,
                    r.title,
                    r.author,
                    r.ingredients,
                    r.instructions)
            repository.updateRecipe(recipe)
                }
        }

    fun deleteRecipe(recipeID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val recipe = RecipeDetails(recipeID, "","","","")
            repository.deleteRecipe(recipe)
        }
    }

}