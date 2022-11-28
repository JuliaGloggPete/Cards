package com.example.highlow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GarbagePileRecycleAdapter(val context: Context, val garbagelist : List<Card>) : RecyclerView.Adapter <GarbagePileRecycleAdapter.ViewHolder>(){

var layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val itemView =layoutInflater.inflate(R.layout.list_item,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
 val oldCard = garbagelist[position]
        //holder.oldCardTextView.text = oldCard.image.toString()
        //var showOldCard= oldCard.image
        //holder.oldCardTextView.text = oldCard.value.toString()
        holder.oldCardImgeView.setImageResource(oldCard.image)
       // holder.oldCardTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0,showOldCard,0,0)



     //  holder.oldCardTextView.compoundDrawables = garbagelist.

    }

    override fun getItemCount(): Int {



        return garbagelist.size-1
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
      // var oldCardTextView = itemView.findViewById<TextView>(R.id.tv_oldCard)
        //var oldCardSuitTextView = itemView.findViewById<TextView>(R.id.tv_oldCardsuit)
        var oldCardImgeView = itemView.findViewById<ImageView>(R.id.iv_oldCard)



    }
}