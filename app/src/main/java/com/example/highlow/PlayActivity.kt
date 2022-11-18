package com.example.highlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PlayActivity : AppCompatActivity() {
    val cardDeck = Deck()


    lateinit var showCardImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)


        val higherButton = findViewById<Button>(R.id.higherButton3)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val equalButton = findViewById<Button>(R.id.equalbutton)
        showCardImage = findViewById(R.id.iv_Card)
        showCardImage.setImageResource(cardDeck.drawnCard().image)






        higherButton.setOnClickListener {

            //if(cardDeck.drawnCard().value)


            showCardImage.setImageResource(cardDeck.drawnCard().image)
        }

        lowerButton.setOnClickListener {
            showCardImage.setImageResource(cardDeck.drawnCard().image)
        }

        equalButton.setOnClickListener {

            showCardImage.setImageResource(cardDeck.drawnCard().image)

        }


    }


}