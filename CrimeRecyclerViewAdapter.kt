package com.example.lab15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrimeRecyclerViewAdapter(private val crimeList : List<Crime>) : RecyclerView.Adapter<CrimeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_crime, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = crimeList[position].title
        holder.dateView.text = crimeList[position].date.toString()
    }

    override fun getItemCount(): Int {
        return crimeList.size;
    }

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val titleView : TextView
        val dateView : TextView

        init {
            titleView = view.findViewById(R.id.crime_title)
            dateView = view.findViewById(R.id.crime_date)
        }
    }
}