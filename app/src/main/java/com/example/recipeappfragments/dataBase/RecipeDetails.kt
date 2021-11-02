package com.example.recipeappfragments.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipe")
data class RecipeDetails (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int =0 ,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "ingredients")
    val ingredients: String,
    @ColumnInfo(name = "instructions")
    val instructions: String
    )