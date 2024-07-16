package com.example.turismoapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AlertDialog
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
        val btnViewMore2 = findViewById<Button>(R.id.btnViewMore2)
        val btnViewMore3 = findViewById<Button>(R.id.btnViewMore3)

        textViewName.text = destination.name
        textViewDescription.text = destination.description
        //textViewDescription.text = destination.titles  // Esto para poder ver la descripción de los sub destinos debajo del subtitulo

        btnViewMore.text = destination.getTitle(0)
        btnViewMore2.text = destination.getTitle(1)
        btnViewMore3.text = destination.getTitle(2)

        btnViewMore.setOnClickListener {
            val intent = Intent(this, WebContentActivity::class.java)
            intent.putExtra("url", destination.getUrl(0))
            startActivity(intent)
        }

        // Copiados del de arriba, para que los otros botones tengan link destino url

        btnViewMore2.setOnClickListener {
            val intent = Intent(this, WebContentActivity::class.java)
            intent.putExtra("url", destination.getUrl(1))
            startActivity(intent)
        }

        btnViewMore3.setOnClickListener {
            val intent = Intent(this, WebContentActivity::class.java)
            intent.putExtra("url", destination.getUrl(2))
            startActivity(intent)
        }
    }


}
