package com.example.saborapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    // FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvNoAccount = findViewById<TextView>(R.id.tvNoAccount)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        //Iniciar FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        tvNoAccount.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        btnLogin.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {

        val etEmail = findViewById<TextView>(R.id.etEmail)
        val etPassword = findViewById<TextView>(R.id.etPassword)

        email = etEmail.text.toString().trim()
        password = etPassword.text.toString().trim()

        // Validamos los datos
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            // Formato invalido de email
            etEmail.error = "Formato inválido de email"
        }
        else if(TextUtils.isEmpty(password)){
            // No se ingresa contraseña
            etPassword.error = "Por favor ingrese una contraseña"
        }
        else{
            // Datos validos
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                // Obtenemos info del usuario
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Autenticado como $email", Toast.LENGTH_SHORT).show()

                // Iniciamos la actividad de información del perfil
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            }
            .addOnFailureListener{ e->
                // Si falla el login
                Toast.makeText(this,"Fallo de autenticación ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            // Ya ha iniciado sesión
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }
    }
}