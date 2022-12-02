package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val backToMenueButton = findViewById<Button>(R.id.btn_backToMenue)
        val againButton = findViewById<Button>(R.id.btn_playAgain)


        backToMenueButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        againButton.setOnClickListener {

            startPlayActivity()

        }


    }

    fun startPlayActivity() {
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
    }

}