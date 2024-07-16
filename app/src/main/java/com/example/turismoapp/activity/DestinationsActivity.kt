package com.example.turismoapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turismoapp.DBHandler
import com.example.turismoapp.DestinationAdapter
import com.example.turismoapp.R

class DestinationsActivity : AppCompatActivity() {

    private lateinit var dbHandler: DBHandler
    private lateinit var recyclerView: RecyclerView
    private lateinit var destinationAdapter: DestinationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinations)

        dbHandler = DBHandler(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val destinations = dbHandler.getDestinations()
        destinationAdapter = DestinationAdapter(destinations) { destination ->
            val intent = Intent(this, SelectionActivity::class.java)
            intent.putExtra("destination", destination)
            startActivity(intent)
        }

        recyclerView.adapter = destinationAdapter
    }
  /* esto es para añadir dialogo --->>>>


    val builder = AlertDialog.Builder(this)
    builder.setTitle("DIALOGO")
    builder.setMessage("Va a entrar en un destino turístico")
    builder.setPositiveButton("OK") { dialog, which ->
        // handle OK button click
    }
    builder.setNegativeButton("Cancel") { dialog, which ->
        // handle Cancel button click
    }
    val dialog = builder.create()
    dialog.show()*/
}