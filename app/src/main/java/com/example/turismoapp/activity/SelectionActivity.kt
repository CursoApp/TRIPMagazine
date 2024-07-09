package com.example.turismoapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import com.example.turismoapp.Destination
import com.example.turismoapp.R

class SelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        val destination = intent.getSerializableExtra("destination") as Destination

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)
        val btnViewMore = findViewById<Button>(R.id.btnViewMore)

        textViewName.text = destination.name
        textViewDescription.text = destination.description

        btnViewMore.setOnClickListener {
            val intent = Intent(this, WebContentActivity::class.java)
            intent.putExtra("url", destination.url)
            startActivity(intent)
        }
    }
}
