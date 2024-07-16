package com.example.turismoapp

import java.io.Serializable

data class Destination
    (val id: Int,
     val name: String,
     val description: String,
     val titles: String,
     val url: String
            )

    : Serializable

{
    fun getUrl(index: Int) : String {
        return try {
            url.split(", ")[index]
        } catch (e: IndexOutOfBoundsException) {
            url
        }
    }

    /* Este código es para q la descripción en DBHandler, acompaña a
    las direcciones WEB tengan en cuenta la forma de separación de los "titles"*/

    fun getTitle(index: Int) : String {
        return try {
            titles.split(" - ")[index]
        } catch (e: IndexOutOfBoundsException) {
            titles
        }
    }
}

