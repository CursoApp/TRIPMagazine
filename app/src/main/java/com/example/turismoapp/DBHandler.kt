package com.example.turismoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 7
        private const val DATABASE_NAME = "DestinationsDB"
        private const val TABLE_DESTINATIONS = "Destinations"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_DESCRIPTION = "description"
        private const val KEY_URL = "url"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE " + TABLE_DESTINATIONS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_URL + " TEXT" + ")")
        db?.execSQL(createTable)
        addInitialDestinations(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_DESTINATIONS")
        onCreate(db)
    }

    private fun addInitialDestinations(db: SQLiteDatabase?) {
        val destinations = listOf(
            Destination(1, "MADRID DE LOS AUSTRIAS", "Parte I.", "https://www.tripmagazine.eu/TRIP_Magazine/int/trip_int2.html"),
            Destination(2, "LIMA", "La ciudad de los Reyes.", "https://www.tripmagazine.eu/TRIP_Magazine/costa/trip_costa2.html"),
            Destination(3, "EUROPA", "Tierra de vinos.", "https://www.tripmagazine.eu/TRIP_Magazine/cultural/trip_cul.html"),
            Destination(4, "BLOG TRIP Magazine", "Nuestro Blog.", "https://tripmagazine.blogspot.com")
        )

        for (destination in destinations) {
            val values = ContentValues()
            values.put(KEY_ID, destination.id)
            values.put(KEY_NAME, destination.name)
            values.put(KEY_DESCRIPTION, destination.description)
            values.put(KEY_URL, destination.url)
            db?.insert(TABLE_DESTINATIONS, null, values)
        }
    }

    fun getDestinations(): List<Destination> {
        val destinationList = ArrayList<Destination>()
        val selectQuery = "SELECT * FROM $TABLE_DESTINATIONS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val destination = Destination(
                    cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_URL))
                )
                destinationList.add(destination)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return destinationList
    }
}
