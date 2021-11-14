package com.example.saborapp.views

// Desarrollo del Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar
import com.example.saborapp.R
import com.example.saborapp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityProfileBinding

    //ActionBar
    private lateinit var actionBar: ActionBar

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configure ActionBar
        actionBar = supportActionBar!!
        actionBar.title = "Perfil"

        // init Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click
        binding.logoutBtn.setOnClickListener{
            firebaseAuth.signOut()
            checkUser()
        }

    }

    private fun checkUser() {
        // Verificar si el usuario esta logeado
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            // Usuario Logeado
            val email = firebaseUser.email
            binding.emailTV.text = email
        }else{
            // Usuario no Logeado
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}