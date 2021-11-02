package com.example.recipeappfragments.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [RecipeDetails::class],version = 1,exportSchema = false)
abstract class RecipeDatabase:RoomDatabase() {

    companion object{
        var instance: RecipeDatabase?=null;
        fun getInstance(ctx: Context): RecipeDatabase
        {
            if(instance !=null)
            {
                return  instance as RecipeDatabase;
            }
            instance = Room.databaseBuilder(ctx, RecipeDatabase::class.java,"details").run { allowMainThreadQueries() }.build();
            return instance as RecipeDatabase;
        }
    }
    abstract fun RecipeDao(): RecipeDao;
}