package com.example.highlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

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
        showCardImage.setImageResource(cardDeck.cardList[0].image)


        higherButton.setOnClickListener {
            cardDeck.drawnCard()
            if(cardDeck.currentCard.value > cardDeck.drawnCard.value){val toast =
                Toast.makeText(this,"${cardDeck.currentCard.value}highter ${cardDeck.drawnCard.value}" , Toast.LENGTH_SHORT)
                toast.show()


            } else{val toast = Toast.makeText(this,"${cardDeck.currentCard.value}lower!${cardDeck.drawnCard.value.toString()}", Toast.LENGTH_SHORT)
                toast.show()}




            showCardImage.setImageResource(cardDeck.currentCard.image)

        }

        lowerButton.setOnClickListener {
            showCardImage.setImageResource(cardDeck.drawnCard.image)
        }

        equalButton.setOnClickListener {

            showCardImage.setImageResource(cardDeck.drawnCard().image)

        }


    }


}