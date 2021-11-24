package com.example.saborapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.saborapp.R
import com.example.saborapp.databinding.ActivityLoginBinding
import com.example.saborapp.databinding.ActivityMainBinding
import com.example.saborapp.databinding.ActivityProfileBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityMainBinding

    // ActionBar
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_SaborApp)
        super.onCreate(savedInstanceState)

        //View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Actionbar config
        actionBar = supportActionBar!!
        //actionBar.title = "Iniciar Sesión"
        actionBar.hide()

        // Botones de Navegacion
        binding.btnRecipe.setOnClickListener{
            startActivity(Intent(this,RecipeActivity::class.java))
        }

        binding.btnProfile.setOnClickListener{
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        binding.btnAboutUs.setOnClickListener{
            startActivity(Intent(this,AboutActivity::class.java))
        }

    }
}