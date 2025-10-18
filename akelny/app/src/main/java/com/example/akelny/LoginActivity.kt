package com.example.akelny

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.editTextEmail)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedEmail = sharedPref.getString("email", null)
        val savedPassword = sharedPref.getString("password", null)

        btnLogin.setOnClickListener {
            val emailText = email.text.toString()
            val passText = password.text.toString()

            if (emailText == savedEmail && passText == savedPassword) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
