package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayActivity : AppCompatActivity() {
    private val cardDeck = Deck()
    private var rightGuess = 0
    private var lives = 15
    private var round = 1
    private lateinit var scoreView: TextView
    private lateinit var livesLeft: TextView
    private lateinit var roundView: TextView

    lateinit var showCardImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        scoreView = findViewById(R.id.scoreView)
        scoreView.text = "Score ${rightGuess}"
        livesLeft = findViewById(R.id.lifes)
        roundView = findViewById(R.id.tv_round)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val higherButton = findViewById<Button>(R.id.higherButton)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val equalButton = findViewById<Button>(R.id.equalbutton)
        showCardImage = findViewById(R.id.iv_Card)
        showCardImage.setImageResource(cardDeck.cardList[0].image)
        cardDeck.garbageList.add(cardDeck.cardList[0])

        higherButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()

            if (cardDeck.currentCard.value > cardDeck.nextCard.value) {
                rightGuess++

            } else {
                wrongAnswerConsequences()

            }
            scoreAndCardsViewHandling()
            val adapter = GarbagePileRecycleAdapter(this, cardDeck.garbageList)
            recyclerView.adapter = adapter

        }

        lowerButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()
            if (cardDeck.currentCard.value < cardDeck.nextCard.value) {
                rightGuess++
            } else {
                wrongAnswerConsequences()
            }
            scoreAndCardsViewHandling()
            val adapter = GarbagePileRecycleAdapter(this, cardDeck.garbageList)
            recyclerView.adapter = adapter

        }

        equalButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()
            if (cardDeck.currentCard.value == cardDeck.nextCard.value) {
                rightGuess++
            } else {
                wrongAnswerConsequences()
            }
            scoreAndCardsViewHandling()
            val adapter = GarbagePileRecycleAdapter(this, cardDeck.garbageList)
            recyclerView.adapter = adapter

        }

        livesLeft.text = "$lives lives left"
        roundView.text = "Round $round"
    }

    private fun startGameOverActivity() {
        val intent = Intent(this, GameOverActivity::class.java)
        startActivity(intent)
    }

    private fun checkWin() {
        if (cardDeck.cardList.size.equals(1)) {
            val toast =
                Toast.makeText(
                    this,
                    "You made it through a whole round and got 2 more lives",
                    Toast.LENGTH_SHORT
                )
            toast.show()
            lives += 2
            round++
            roundView.text = "Round $round"

            cardDeck.newRound()
        }
    }

    private fun wrongAnswerConsequences() {

        lives--
        livesLeft.text = " $lives lives left"
        if (lives == 0) {
            startGameOverActivity()

        }

    }

    private fun scoreAndCardsViewHandling() {

        var cardsLeft = cardDeck.cardList.size
        showCardImage.setImageResource(cardDeck.currentCard.image)
        scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

    }

}