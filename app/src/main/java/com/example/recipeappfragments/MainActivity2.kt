package com.example.recipeappfragments

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeappfragments.adapter.RecyclerViewAdapter
import com.example.recipeappfragments.dataBase.RecipeDetails
import com.example.recipeappviewmodel.viewModel.MyViewModel

class MainActivity2 : AppCompatActivity() {
    //private var words = listOf<RecipeDetails>()
    lateinit var myRv: RecyclerView
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}
//    lateinit var Rv : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        myRv = findViewById(R.id.recyclerView)
       // Rv = RecyclerViewAdapter(this)
        myViewModel.getRecipes().observe(this, {
         //       recipes -> Rv.update(recipes)
            println("show")
        })
     //   myRv.adapter = Rv
     //   myRv.layoutManager = LinearLayoutManager(this)
    }

    fun update(ID:Int) {
        val dialogBuilder = Dialog(this)
        val dialogView = layoutInflater.inflate(R.layout.update_dialog, null)
        dialogBuilder.setTitle("Alert Dialog")
        dialogBuilder.setContentView(dialogView)
        val edtitle = dialogView.findViewById<EditText>(R.id.edtitle)
        val edautor = dialogView.findViewById<EditText>(R.id.edtitle2)
        val edInt = dialogView.findViewById<EditText>(R.id.edmore2)
        val edIns = dialogView.findViewById<EditText>(R.id.eddes2)
        val tvBtn = dialogView.findViewById<Button>(R.id.button7)
        tvBtn.setOnClickListener {
            if (edtitle.text.isEmpty() || edautor.text.isEmpty() || edInt.text.isEmpty()|| edIns.text.isEmpty())
                Toast.makeText(this, "Fill all fields please", Toast.LENGTH_SHORT).show()
            else {
                var title = edtitle.text.toString()
                var author = edautor.text.toString()
                var ingredients = edInt.text.toString()
                var instructions = edIns.text.toString()
                val recipe = RecipeDetails(ID,
                    title,
                    author,
                    ingredients,
                    instructions)
                myViewModel.updateRecipe(recipe)
                dialogBuilder.dismiss()
                Toast.makeText(applicationContext, "data updated successfully! ", Toast.LENGTH_SHORT)
                    .show()
                println("updated item")
            }
        }
        dialogBuilder.show()
    }

    fun delete(id: Int) {
        myViewModel.deleteRecipe(id)
        Toast.makeText(applicationContext, "data deleted successfully! ", Toast.LENGTH_SHORT).show()
    }
}

