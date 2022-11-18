package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

  //  var deck: Deck()
    val cardDeck = Deck()

    lateinit var welcomeTextView :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.welcomeTextView)

        // android:id="@+id/welcomeTextView" hittade inte men om jag tog bort o satt dit igen så gick det





        val playButton = findViewById<Button>(R.id.playButton)

        playButton.setOnClickListener {


            startPlayActivity()


        }


}
    fun startPlayActivity() {
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)


    }
    }