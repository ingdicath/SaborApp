package com.example.saborapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.saborapp.databinding.ActivityRecipeBinding
import com.example.saborapp.models.RecipeModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RecipeActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityRecipeBinding

    // ActionBar
    private lateinit var actionBar: ActionBar

    private val listRecipes:MutableList<RecipeModel> = ArrayList()

    //Firebase
    private val dbRef = Firebase.database.reference

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //View Binding
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Actionbar config
        actionBar = supportActionBar!!
        actionBar.title = "Mis recetas"

        // init Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        //User Data
        val uid = firebaseAuth.currentUser?.uid

        if (uid != null) {
            dbRef.child(uid).child("recipes").child("name").get()
                .addOnSuccessListener {
                    binding.tvRecipeName.text = "${it.value}"
                }
                .addOnFailureListener{
                    it.printStackTrace()
                }

            dbRef.child(uid).child("recipes").child("time").get()
                .addOnSuccessListener {
                    binding.tvRecipeTime.text = "${it.value}"
                }
                .addOnFailureListener{
                    it.printStackTrace()
                }
        }




        // Invocar la pantalla Agregar receta
        binding.floatingButtonRecipe.setOnClickListener{
            startActivity(Intent(this,AddRecipeActivity::class.java))
        }




    }




}