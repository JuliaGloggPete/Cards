package com.example.highlow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PlayedCardsRecycleAdapter(val context: Context, val listOfPlayedCards: List<Card>) :
    RecyclerView.Adapter<PlayedCardsRecycleAdapter.ViewHolder>() {

    var layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item_played_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val oldCard = listOfPlayedCards[position]
        holder.oldCardImgeView.setImageResource(oldCard.image)


    }

    override fun getItemCount(): Int {


        return listOfPlayedCards.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
              var oldCardImgeView = itemView.findViewById<ImageView>(R.id.iv_oldCard)


    }
}