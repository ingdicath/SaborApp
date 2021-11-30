package com.example.saborapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    // FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        //Iniciar FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            validateData()
        }

    }

    private fun validateData() {

        val etEmail = findViewById<TextView>(R.id.etEmail)
        val etPassword = findViewById<TextView>(R.id.etPassword)

        // Obtenemos los datos
        email = etEmail.text.toString().trim()
        password = etPassword.text.toString().trim()

        // Validamos los datos
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            // Datos invalidos
            etEmail.error = "Formato de email invalido"
        }
        else if(password.length <6){
            // Password length is less than
            etPassword.error = "La contraseña debe tener almenos 6 caracteres"
        }
        else{
            // Datos validos
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {

        // Crear Cuenta
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                // Obtener Usuario Actual
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Cuenta creada correctamente con email $email", Toast.LENGTH_SHORT).show()

                //Inciar Actividad
                startActivity(Intent(this, MenuActivity::class.java))
                finish()
            }
            .addOnFailureListener{ e->
                // Registro Fallido
                Toast.makeText(this,"Fallo en el registro ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Volver a la actividad previa
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}