package com.example.akelny

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
