package com.example.saborapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.saborapp.R
import com.example.saborapp.databinding.ActivityAboutBinding
import com.example.saborapp.databinding.ActivityMainBinding
import com.example.saborapp.databinding.ActivityRecipeBinding

class AboutActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var binding: ActivityAboutBinding

    // ActionBar
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //View Binding
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Actionbar config
        actionBar = supportActionBar!!
        actionBar.hide()
    }
}