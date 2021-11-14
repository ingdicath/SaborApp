package com.example.saborapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.saborapp.R
import com.example.saborapp.models.RecipeModel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class RecipeActivity : AppCompatActivity() {

    private val listRecipes:MutableList<RecipeModel> = ArrayList()
    private val dbRef = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        // TODO Investigar CRUD FIREBASE
        //var uid: String = "uid1"
        //var recipesRef = dbRef.child(uid).child("recipes")
        // val recipe = RecipeModel("2","Ramen","1","2min","Fideos","Cocinarlo")







    }



}