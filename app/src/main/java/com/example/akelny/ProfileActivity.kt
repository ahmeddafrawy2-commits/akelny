package com.example.akelny

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val name = sharedPref.getString("name", "Unknown User")
        val email = sharedPref.getString("email", "No Email")
        val phone = sharedPref.getString("phone", "No Phone")

        val textProfile = findViewById<TextView>(R.id.textProfile)
        val btnBack = findViewById<Button>(R.id.btnBack)

        textProfile.text = "Name: $name\nEmail: $email\nPhone: $phone"

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
