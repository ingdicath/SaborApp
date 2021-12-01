package com.example.saborapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnRecipe = findViewById<ImageButton>(R.id.btnRecipe)
        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        val btnAboutUs = findViewById<ImageButton>(R.id.btnAboutUs)

        btnRecipe.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }

        btnAboutUs.setOnClickListener{
            startActivity(Intent(this,AboutActivity::class.java))
        }
    }
}