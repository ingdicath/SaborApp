package com.example.saborapp.views

// Desarrollo del LOGIN

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.saborapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    // ViewBinding
    private lateinit var binding: ActivityLoginBinding

    // ActionBar
    private lateinit var actionBar: ActionBar

    // ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    // FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Actionbar config
        actionBar = supportActionBar!!
        //actionBar.title = "Iniciar Sesión"
        actionBar.hide()

        // Progress Dialog Config
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Por favor espera")
        progressDialog.setMessage("Iniciando Sesión...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, open register activity
        binding.noAccountTV.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //handle click, begin login
        binding.btnLogin.setOnClickListener{
            // Antes de logear validamos los datos
            validateData()
        }
    }

    private fun validateData() {
        // Obtenemos los datos
        email = binding.etEmail.text.toString().trim()
        password = binding.etPassword.text.toString().trim()

        // Validamos los datos
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            // Formato invalido de email
            binding.etEmail.error = "Formato inválido de email"
        }
        else if(TextUtils.isEmpty(password)){
            // No se ingresa contraseña
            binding.etPassword.error = "Por favor ingrese una contraseña"
        }
        else{
            // Datos validos
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                // Obtenemos info del usuario
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Autenticado como $email", Toast.LENGTH_SHORT).show()

                // Iniciamos la actividad de información del perfil
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener{ e->
                // Si falla el login
                progressDialog.dismiss()
                Toast.makeText(this,"Fallo de autenticación ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            // Ya ha iniciado sesión
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


}