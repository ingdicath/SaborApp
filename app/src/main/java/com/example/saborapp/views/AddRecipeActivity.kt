package com.example.saborapp.views

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.saborapp.databinding.ActivityAddRecipeBinding
import com.example.saborapp.models.RecipeModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddRecipeActivity : AppCompatActivity() {

	//ViewBinding
	private lateinit var binding: ActivityAddRecipeBinding

//	// Image - check this
//	private lateinit var ImageUri: Uri

	//Firebase
	private val dbRef = Firebase.database.reference

	//FirebaseAuth
	private lateinit var firebaseAuth: FirebaseAuth

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		//View Binding
		binding = ActivityAddRecipeBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// init Firebase Auth
		firebaseAuth = FirebaseAuth.getInstance()

		binding.btnSave.setOnClickListener {

			//User Data
			val uid = firebaseAuth.currentUser?.uid

			//Recipe Data
			val id = "1"
			val name = binding.etRecipeName.text.toString()
			val portions = binding.etNumPortions.text.toString()
			val time = binding.etCookingTime.text.toString()
			val ingredients = binding.etIngredients.text.toString()
			val instructions = binding.etInstructions.text.toString()

			val recipeData = RecipeModel(id, name, portions, time, ingredients, instructions)

			if (uid != null) {
				dbRef.child(uid).child("recipes").setValue(recipeData)
					.addOnSuccessListener {
						Toast.makeText(this, "Receta guardada correctamente", Toast.LENGTH_SHORT)
							.show()
						startActivity(Intent(this, RecipeActivity::class.java))
						finish()
					}
					.addOnFailureListener {
						it.printStackTrace()
					}
			}
		}

		binding.btnAddImageRecipe.setOnClickListener {
			selectImage()
		}

	}

	// selected image from cellphone - check this
	private fun selectImage() {
		val intent = Intent()
		intent.type = "images/*"
		intent.action = Intent.ACTION_GET_CONTENT
		startActivityForResult(intent, 100)
	}

//	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//		super.onActivityResult(requestCode, resultCode, data)
//		if (requestCode == 100 && resultCode == RESULT_OK) {
//			ImageUri = data?.data!!
//			binding.firebaseImage.setImageURI(ImageUri)
//		}
//	}
}
