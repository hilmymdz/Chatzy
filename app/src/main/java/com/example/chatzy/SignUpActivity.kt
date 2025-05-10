package com.example.chatzy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    private val TAG = "SignUpActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        Log.d(TAG, "Activity Created")

        val nameInput = findViewById<EditText>(R.id.btnName)
        val emphInput = findViewById<EditText>(R.id.btnmorp)
        val passInput = findViewById<EditText>(R.id.btnpass)
        val confirmPassInput = findViewById<EditText>(R.id.btncpass)
        val signUpBtn = findViewById<Button>(R.id.btnSign)
        val loginLink = findViewById<TextView>(R.id.txtLgn)

        signUpBtn.setOnClickListener {
            Log.d(TAG, "Sign Up button clicked")
            if(validateInputs(
                nameInput,
                emphInput,
                passInput,
                confirmPassInput
            )) {
                showLoadigToast()

                Handler(Looper.getMainLooper()).postDelayed({
                    Log.d(TAG, "Sign Up Succesfull")
                    Toast.makeText(this,
                        "Sign Up successful! Redirecting...",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }, 2000)
            }else {
                Log.w(TAG, "Validation Failed!")
                Toast.makeText(
                    this,
                    "Please check your input fields!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        loginLink.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    private fun validateInputs(
        name: EditText,
        email: EditText,
        password: EditText,
        confirmPassword: EditText
    ): Boolean {
        Log.d(TAG, "Validating inputs...")
        var isValid = true

        if(name.text.toString().trim().isEmpty()) {
            name.error = "Name required"
            Log.w(TAG, "Name validation failed")
            isValid = false
        }

        if(email.text.toString().trim().isEmpty()) {
            email.error = "Email/Phone required"
            Log.w(TAG, "Email validation failed")
            isValid = false
        }

        if(password.text.toString().trim().isEmpty()) {
            password.error = "Password required"
            Log.w(TAG, "Password validation failed")
            isValid = false
        }

        if(confirmPassword.text.toString() != password.text.toString()) {
            confirmPassword.error = "Password doesn't match"
            Log.w(TAG, "Password confirmation failed")
            isValid = false
        }

        return isValid
    }

    private fun showLoadigToast() {
        Toast.makeText(
            this,
            "Processing your registration...",
            Toast.LENGTH_SHORT
        ).show()
        Log.d(TAG, "Showing loading toast")
    }
}