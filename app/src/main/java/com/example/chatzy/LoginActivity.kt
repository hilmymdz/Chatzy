package com.example.chatzy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val emaiphoneInput = findViewById<EditText>(R.id.editMorp)
        val passwordInput = findViewById<EditText>(R.id.editPass)
        val loginButton = findViewById<Button>(R.id.btnLgn)
        val signupLink = findViewById<TextView>(R.id.txtRegister)
        val forgotPassword = findViewById<TextView>(R.id.txtForpass)
        val buttonBack = findViewById<ImageView>(R.id.btnloginBack)

        loginButton.setOnClickListener {
            if(validateInputs(emaiphoneInput, passwordInput)){
                startActivity(Intent(this, ListChatActivity::class.java))
            }
        }

        signupLink.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        forgotPassword.setOnClickListener{

        }

        buttonBack.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }
    }
    private fun validateInputs(
        email: EditText,
        password: EditText
    ): Boolean {
        var isValid = true

        if(email.text.toString().trim().isEmpty()) {
            email.error = "Email/Phone required"
            isValid = false
        }

        if(password.text.toString().trim().isEmpty()) {
            password.error = "Password required"
            isValid = false
        }

        return isValid
    }
}