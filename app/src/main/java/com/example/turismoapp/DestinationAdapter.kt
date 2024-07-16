package com.example.turismoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinationAdapter(private var destinations: List<Destination>, private val clickListener: (Destination) -> Unit) :
    RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destination = destinations[position]
        holder.textView.text = destination.name
        //holder.textView.text = destination.titles
        holder.itemView.setOnClickListener { clickListener(destination) }
    }

    override fun getItemCount() = destinations.size

    /* Este código de abajo, es para crear una búsqueda  de destinos de una nueva manera */
    fun updateData(dataSet: List<Destination>) {
        this.destinations = dataSet
        notifyDataSetChanged()
    }
}
