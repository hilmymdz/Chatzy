package com.example.chatzy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Install splash screen pertama
        runBlocking {
            installSplashScreen()
            delay(1000)
        }

        // 2. Panggil super.onCreate() setelahnya
        super.onCreate(savedInstanceState)

        // 3. Pastikan nama layout benar
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 5. Pindah ke ChooseActivity
        startActivity(Intent(this, ChooseActivity::class.java))
        finish()
    }
}