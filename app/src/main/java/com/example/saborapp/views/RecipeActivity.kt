package com.example.saborapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.example.saborapp.R
import com.example.saborapp.databinding.ActivityMainBinding
import com.example.saborapp.databinding.ActivityRecipeBinding
import com.example.saborapp.models.RecipeModel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class RecipeActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityRecipeBinding

    // ActionBar
    private lateinit var actionBar: ActionBar

    private val listRecipes:MutableList<RecipeModel> = ArrayList()
    private val dbRef = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //View Binding
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Actionbar config
        actionBar = supportActionBar!!
        //actionBar.hide()
        actionBar.title = "Mis recetas"

        // Invocar la pantalla Agregar receta
        binding.floatingButtonRecipe.setOnClickListener{
            startActivity(Intent(this,AddRecipeActivity::class.java))
        }

        // TODO Investigar CRUD FIREBASE
        //var uid: String = "uid1"
        //var recipesRef = dbRef.child(uid).child("recipes")
        // val recipe = RecipeModel("2","Ramen","1","2min","Fideos","Cocinarlo")

    }




}