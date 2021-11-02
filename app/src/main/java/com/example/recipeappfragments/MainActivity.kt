package com.example.recipeappfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappfragments.dataBase.RecipeDetails
import com.example.recipeappviewmodel.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}
   val title = findViewById<EditText>(R.id.edTitle)
        val name = findViewById<EditText>(R.id.edName)
        val Ingredents = findViewById<EditText>(R.id.edIngredents)
        val Instruction = findViewById<EditText>(R.id.edInstruction)
        val savebtn = findViewById<Button>(R.id.btsave)
        val view = findViewById<Button>(R.id.btview)

        view.setOnClickListener {
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
        savebtn.setOnClickListener {
            if (title.text.isEmpty() ||
                    name.text.isEmpty() ||
                    Ingredents.text.isEmpty() ||
                    Instruction.text.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all field please!! ", Toast.LENGTH_LONG).show()
                println("Fill all field please!! ")
            }
            else {
                var Recipe = RecipeDetails(
                        0,
                        title.text.toString(),
                        name.text.toString(),
                        Ingredents.text.toString(),
                        Instruction.text.toString()
                )
                myViewModel.addRecipe(Recipe)
                Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                        .show()
                title.setText("")
                name.setText("")
                Ingredents.setText("")
                Instruction.setText("")
            }
        }
    }
 */