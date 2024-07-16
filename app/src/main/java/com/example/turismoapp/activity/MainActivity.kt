package com.example.turismoapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import com.example.turismoapp.R

import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            val intent = Intent(this, DestinationsActivity::class.java)
            startActivity(intent)
        }

        //a qui empieza dialogo code

        /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)*/

        // Botón que abrirá el diálogo
        val showDialogButton: Button = findViewById(R.id.showDialogButton)
        showDialogButton.setOnClickListener {
            showDialog()
        }
    }

        private fun showDialog() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dialogo amistoso")
            builder.setMessage("¿Deseas continuar?")
            builder.setPositiveButton("Sí") { dialog, which ->
                // Acción cuando el usuario hace clic en "Sí"
            }
            builder.setNegativeButton("No") { dialog, which ->
                // Acción cuando el usuario hace clic en "No"
            }
            builder.setNeutralButton("Cancelar") { dialog, which ->
                // Acción cuando el usuario hace clic en "Cancelar"
            }
            builder.show()

            // Aquí TERMINA Dialogocode

        }

        //Aqui empieza copia code del 15 de julio24
        @OptIn(DelicateCoroutinesApi::class)
        fun main() {
            val url = "https://www.tripmagazine.eu" // URL de la página web que quieres analizar

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    // Conectar y obtener el documento HTML de la página web
                    val document: Document = Jsoup.connect(url).get()

                    // Buscar elementos específicos, por ejemplo, todos los elementos <p>
                    val elements: Elements = document.select("repor")

                    // Imprimir el texto de cada elemento <p>
                    withContext(Dispatchers.Main) {
                        for (element in elements) {
                            println(element.text())
                        }
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    // Aquí termina el code del 15 de julio24
}




