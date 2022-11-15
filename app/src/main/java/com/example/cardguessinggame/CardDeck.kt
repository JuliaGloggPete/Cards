package com.example.cardguessinggame

import android.util.Log

class CardDeck {
    val cardList = mutableListOf<Cards>()

    val values = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13)
    var suits = arrayOf("Hearts","Diamonds","Spades","Clubs")
    //lateinit var cards : Cards


    fun createCards(){

        for( number in values){
            for ( suit in suits){

                //rdList.add(Cards(number.toString(),item))
                Log.d("KKK",number.toString()+suit)
                cardList.add(Cards(number,suit))
                //Log.d("HHH",cardList.indexOf(Cards(1,"Clubs")))

            }}


        }
}






