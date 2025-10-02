package com.yourpackage.groundshunt // ⬅️ Change this to your actual package name

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.groundshunt.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toggleSignUp: TextView = findViewById(R.id.toggle_signup)
        val loginButton: Button = findViewById(R.id.login_button)


        toggleSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: prevent user from returning to LoginActivity using back button
        }
    }
}
