package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ContentInfoCompat.Flags

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val quitButton = findViewById<Button>(R.id.btn_quit)
        val againButton = findViewById<Button>(R.id.btn_playAgain)


        quitButton.setOnClickListener {
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