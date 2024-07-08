package com.example.turismoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            val intent = Intent(this, DestinationsActivity::class.java)
            startActivity(intent)
        }
    }
}




