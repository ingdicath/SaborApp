package com.example.saborapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        val btnLogOut = findViewById<Button>(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }

    private fun checkUser() {

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        // Verificar si el usuario esta logeado
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            // Usuario Logeado
            val email = firebaseUser.email
            tvEmail.text = email
        }else{
            // Usuario no Logeado
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}