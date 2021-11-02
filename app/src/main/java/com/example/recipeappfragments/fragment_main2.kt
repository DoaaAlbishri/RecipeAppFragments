package com.example.recipeappfragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeappfragments.adapter.RecyclerViewAdapter
import com.example.recipeappfragments.dataBase.RecipeDetails
import com.example.recipeappviewmodel.viewModel.MyViewModel

class fragment_main2 : Fragment() {
    lateinit var myRv: RecyclerView
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}
    lateinit var Rv : RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main2, container, false)

        myRv = view.findViewById(R.id.recyclerView)
        Rv = RecyclerViewAdapter(this)
        myViewModel.getRecipes().observe(viewLifecycleOwner, {
                recipes -> Rv.update(recipes)
            println("show")
        })
        myRv.adapter = Rv
        myRv.layoutManager = LinearLayoutManager(requireContext())
        return view
    }
    fun update(ID:Int) {
        val dialogBuilder = Dialog(requireContext())
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
                Toast.makeText(requireContext(), "Fill all fields please", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(), "data updated successfully! ", Toast.LENGTH_SHORT)
                    .show()
                println("updated item")
            }
        }
        dialogBuilder.show()
    }

    fun delete(id: Int) {
        myViewModel.deleteRecipe(id)
        Toast.makeText(requireContext(), "data deleted successfully! ", Toast.LENGTH_SHORT).show()
    }

}