package com.example.turismoapp

import java.io.Serializable

data class Destination
    (val id: Int,
     val name: String,
     val description: String,
     val url: String)

    : Serializable

