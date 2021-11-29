package com.example.saborapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.saborapp.databinding.ActivityViewSingleRecipeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewSingleRecipeActivity : AppCompatActivity() {

	//ViewBinding
	private lateinit var binding: ActivityViewSingleRecipeBinding

	// ActionBar
	private lateinit var actionBar: ActionBar

	//Firebase
	private val dbRef = Firebase.database.reference

	//FirebaseAuth
	private lateinit var firebaseAuth: FirebaseAuth

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		//View Binding
		binding = ActivityViewSingleRecipeBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// Actionbar config
		actionBar = supportActionBar!!
		actionBar.title = "Mis recetas"

		// init Firebase Auth
		firebaseAuth = FirebaseAuth.getInstance()

		// Call Edit recipe view
		binding.btnEdit.setOnClickListener {
			startActivity(Intent(this, EditRecipeActivity::class.java))
		}

		// Delete recipe button
		binding.btnDelete.setOnClickListener {
			startActivity(Intent(this, EditRecipeActivity::class.java))
		}
	}
}
