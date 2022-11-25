package com.example.highlow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

  //  var deck: Deck()
    val cardDeck = Deck()

    lateinit var welcomeTextView :TextView
    val rulesFragment = RulesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addWelcomefragment ()


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
    fun addWelcomefragment (){
        val welcomeFragment = WelcomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, welcomeFragment, "welcome")
        transaction.commit()


    }

    fun addRulesFragment (view: View){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, rulesFragment, "rules" )
        transaction.commit()


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event?.action == MotionEvent.ACTION_UP){
            removeRulesFragment()
        }

        return true

    }
    fun removeRulesFragment (){


        if ( rulesFragment != null) {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(rulesFragment)
            transaction.commit()


        }



    }


    }