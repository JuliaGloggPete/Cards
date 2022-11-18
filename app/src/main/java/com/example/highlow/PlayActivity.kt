package com.example.highlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PlayActivity : AppCompatActivity() {
    val cardDeck = Deck()
    var rightGuess = 0
    lateinit var scoreView: TextView


    // todo - winning conditions, write welcome, write rules, change pictures


    lateinit var showCardImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        scoreView = findViewById(R.id.scoreView)
        scoreView.text = "Score ${rightGuess.toString()}"


        val higherButton = findViewById<Button>(R.id.higherButton3)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val equalButton = findViewById<Button>(R.id.equalbutton)
        showCardImage = findViewById(R.id.iv_Card)
        showCardImage.setImageResource(cardDeck.cardList[0].image)


        higherButton.setOnClickListener {
            cardDeck.drawnCard()
            if(cardDeck.currentCard.value > cardDeck.nextCard.value){
                rightGuess++
                //val toast =
                //Toast.makeText(this,"${cardDeck.currentCard.value}highter ${cardDeck.nextCard.value}" , Toast.LENGTH_SHORT)
                //toast.show()

            } //else{val toast = Toast.makeText(this,"${cardDeck.currentCard.value}lower!${cardDeck.nextCard.value.toString()}", Toast.LENGTH_SHORT)
                //toast.show()}
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }

        lowerButton.setOnClickListener {
            cardDeck.drawnCard()
            if(cardDeck.currentCard.value < cardDeck.nextCard.value){
                rightGuess++
            }
            //setter det i fun
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }

        equalButton.setOnClickListener {
            cardDeck.drawnCard()
            if(cardDeck.currentCard.value == cardDeck.nextCard.value){
                rightGuess++
            }
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }


    }


}