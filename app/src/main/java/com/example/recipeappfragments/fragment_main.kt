package com.example.recipeappfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recipeappfragments.dataBase.RecipeDetails
import com.example.recipeappviewmodel.viewModel.MyViewModel


class fragment_main : Fragment() {
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val title = view.findViewById<EditText>(R.id.edTitle)
        val name = view.findViewById<EditText>(R.id.edName)
        val Ingredents = view.findViewById<EditText>(R.id.edIngredents)
        val Instruction = view.findViewById<EditText>(R.id.edInstruction)
        val savebtn = view.findViewById<Button>(R.id.btsave)
        val show = view.findViewById<Button>(R.id.btview)

        show.setOnClickListener {
        findNavController().navigate(R.id.action_fragment_main_to_fragment_main2)
        }

        savebtn.setOnClickListener {
            if (title.text.isEmpty() ||
                name.text.isEmpty() ||
                Ingredents.text.isEmpty() ||
                Instruction.text.isEmpty()
            ) {
                Toast.makeText(requireContext(), "Fill all field please!! ", Toast.LENGTH_LONG)
                    .show()
                println("Fill all field please!! ")
            } else {
                var Recipe = RecipeDetails(
                    0,
                    title.text.toString(),
                    name.text.toString(),
                    Ingredents.text.toString(),
                    Instruction.text.toString()
                )
                myViewModel.addRecipe(Recipe)
                Toast.makeText(requireContext(), "data saved successfully! ", Toast.LENGTH_SHORT)
                    .show()
                title.setText("")
                name.setText("")
                Ingredents.setText("")
                Instruction.setText("")
            }
        }
        return view
        }
}