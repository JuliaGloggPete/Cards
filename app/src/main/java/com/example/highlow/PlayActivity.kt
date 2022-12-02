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
    private var adapter : PlayedCardsRecycleAdapter? = null


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
        showCardImage.setImageResource(cardDeck.listOfCard[0].image)
        cardDeck.listOfplayedCards.add(cardDeck.listOfCard[0])

        higherButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()

            if (cardDeck.currentCard.value > cardDeck.nextCard.value) {
                rightGuess++

            } else {
                wrongAnswerConsequences()

            }
            scoreAndCardsViewHandling()
            updateRecyclerViewData(recyclerView)

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
            updateRecyclerViewData(recyclerView)

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
            updateRecyclerViewData(recyclerView)

        }

       // livesLeft.text = "$lives lives left"
        livesLeft.text = getString(R.string.lives_left, lives.toString())
        roundView.text = getString(R.string.round,round.toString())
    }

    private fun updateRecyclerViewData(recyclerView: RecyclerView) {
        val listOfPlayedCards = cardDeck.listOfplayedCards.toList().toMutableList()
        listOfPlayedCards.removeAt(0)

        adapter = PlayedCardsRecycleAdapter(this, listOfPlayedCards)
        recyclerView.adapter = adapter
    }

    private fun startGameOverActivity() {
        val intent = Intent(this, GameOverActivity::class.java)
        startActivity(intent)
    }

    private fun checkWin() {
        if (cardDeck.listOfCard.size.equals(1)) {
            val toast =
                Toast.makeText(
                    this,
                    getString(R.string.nextRound),
                    Toast.LENGTH_SHORT
                )
            toast.show()
            lives += 2
            round++
            roundView.text = getString(R.string.round,round.toString())
            livesLeft.text = getString(R.string.lives_left, lives.toString())
            cardDeck.newRound()
        }
    }

    private fun wrongAnswerConsequences() {

        lives--
        livesLeft.text = getString(R.string.lives_left, lives.toString())
        if (lives == 0) {
            startGameOverActivity()
        }

    }

    private fun scoreAndCardsViewHandling() {

        val cardsLeft = cardDeck.listOfCard.size
        showCardImage.setImageResource(cardDeck.currentCard.image)
        scoreView.text = getString(R.string.score,rightGuess.toString(),cardsLeft.toString())

    }

}