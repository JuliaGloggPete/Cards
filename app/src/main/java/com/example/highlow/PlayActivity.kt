package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PlayActivity : AppCompatActivity() {
    val cardDeck = Deck()
    var rightGuess = 0
    var lives = 15
    var round = 1
    lateinit var scoreView: TextView
    lateinit var livesleft : TextView


    // todo - winning conditions, write welcome, write rules,
    // play again needs to reset Highlow
    // done change pictures


    lateinit var showCardImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        scoreView = findViewById(R.id.scoreView)
        scoreView.text = "Score ${rightGuess.toString()}"
        livesleft = findViewById(R.id.lifes)




        val higherButton = findViewById<Button>(R.id.higherButton3)
        val lowerButton = findViewById<Button>(R.id.lowerButton)
        val equalButton = findViewById<Button>(R.id.equalbutton)
        showCardImage = findViewById(R.id.iv_Card)
        showCardImage.setImageResource(cardDeck.cardList[0].image)


        higherButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()

            if(cardDeck.currentCard.value > cardDeck.nextCard.value){
                rightGuess++


            } else{
                lives--
               livesleft.text = "you got $lives lives left"
                if (lives==0){
                    startGameOverActivity()
                }
            }


            //else{val toast = Toast.makeText(this,"${cardDeck.currentCard.value}lower!${cardDeck.nextCard.value.toString()}", Toast.LENGTH_SHORT)
                //toast.show()}
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }

        lowerButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()
            if(cardDeck.currentCard.value < cardDeck.nextCard.value){
                rightGuess++
            }else{
                lives--
                livesleft.text = "you got $lives lives left"
                if (lives==0){ startGameOverActivity()

                }
            }
            //setter det i fun
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }

        equalButton.setOnClickListener {
            checkWin()
            cardDeck.drawCard()
            if(cardDeck.currentCard.value == cardDeck.nextCard.value){
                rightGuess++
            }else{
                lives--
                livesleft.text = "you got $lives lives left"
                if (lives==0){
                    startGameOverActivity()
                }

            }
            var cardsLeft = cardDeck.cardList.size
            showCardImage.setImageResource(cardDeck.currentCard.image)
            scoreView.text = "Score ${rightGuess} CardsLeft ${cardsLeft}"

        }


        livesleft.text = "you got $lives lives left"
    }

        fun startGameOverActivity() {
            val intent = Intent(this, GameOverActivity::class.java)
            startActivity(intent)


        }

    fun checkWin(){
        if (cardDeck.cardList.size.equals(1))

        {cardDeck.newRound()
            val toast =
            Toast.makeText(this,"You made it through a whole round and got 2 more lives" , Toast.LENGTH_SHORT)
            toast.show()

            lives+2
            round++

        }

    }



    /*fun addGamOverFragment(){
        val gameOverFragment = GameOverFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_GameOver,gameOverFragment, "gameover")
        transaction.commit()



    }*/
}