package com.example.saborapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// Delay for splash screen
//		val timer: Long = 1400
//		Handler().postDelayed({ startActivity(Intent(this, LoginActivity::class.java)) }, timer)

		startActivity(Intent(this, LoginActivity::class.java))
		finish()
	}
}