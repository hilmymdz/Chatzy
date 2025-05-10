package com.example.chatzy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose)

        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signupButton = findViewById<Button>(R.id.btnSignup)

        loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        signupButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

}