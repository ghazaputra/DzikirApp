package com.example.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ghaza.idn.dzikir_app.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}