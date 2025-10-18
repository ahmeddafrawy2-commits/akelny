package com.example.akelny

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.editTextName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val phoneText = phone.text.toString()
            val passText = password.text.toString()

            if (nameText.isNotEmpty() && emailText.isNotEmpty() && phoneText.isNotEmpty() && passText.isNotEmpty()) {
                // Save all info
                val editor = sharedPref.edit()
                editor.putString("name", nameText)
                editor.putString("email", emailText)
                editor.putString("phone", phoneText)
                editor.putString("password", passText)
                editor.apply()

                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
