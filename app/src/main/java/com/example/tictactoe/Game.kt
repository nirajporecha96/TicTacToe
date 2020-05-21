package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*

class Game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
        setplayer(message)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var currentplayer = 1


    fun setplayer(txt: String) {
        if (txt == "X" || txt == "x") {
            currentplayer = 1
            player1.add(11)
            player2.add(12)
        }
        if (txt == "O" || txt == "o") {
            currentplayer = 2
            player1.add(12)
            player2.add(11)
        }
    }

    fun replay(view: View) {

        player1.clear()
        player2.clear()
        var txt: String = textView.text.toString()

        if (txt == "X" || txt == "x") {
            currentplayer = 1
            player1.add(11)
            player2.add(12)
        }
        if (txt == "O" || txt == "o") {
            currentplayer = 2
            player1.add(12)
            player2.add(11)
        }

        button1.setBackgroundResource(android.R.drawable.btn_default)
        button2.setBackgroundResource(android.R.drawable.btn_default)
        button3.setBackgroundResource(android.R.drawable.btn_default)
        button4.setBackgroundResource(android.R.drawable.btn_default)
        button5.setBackgroundResource(android.R.drawable.btn_default)
        button6.setBackgroundResource(android.R.drawable.btn_default)
        button7.setBackgroundResource(android.R.drawable.btn_default)
        button8.setBackgroundResource(android.R.drawable.btn_default)
        button9.setBackgroundResource(android.R.drawable.btn_default)

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

    }

    fun buttonpress(view: View) {
        val butpressed:Button = view as Button
        var buttid = 0
        when(butpressed.id) {
            R.id.button1 -> buttid = 1
            R.id.button2 -> buttid = 2
            R.id.button3 -> buttid = 3
            R.id.button4 -> buttid = 4
            R.id.button5 -> buttid = 5
            R.id.button6 -> buttid = 6
            R.id.button7 -> buttid = 7
            R.id.button8 -> buttid = 8
            R.id.button9 -> buttid = 9
        }
        playgame(buttid, butpressed)
    }

    private fun playgame(buttid: Int, butpressed: Button) {

        if (currentplayer == 1) {
            butpressed.text = "X"
            butpressed.setBackgroundColor(Color.BLUE)
            player1.add(buttid)
            currentplayer = 2
        }
        else {
            butpressed.text = "O"
            butpressed.setBackgroundColor(Color.RED)
            player2.add(buttid)
            currentplayer = 1
        }
        butpressed.isEnabled = false
        checkwinner()
    }

    private fun checkwinner() {
        var winner = -1
        // Player 1 check
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player1.contains(7) && player1.contains(5) && player1.contains(3)) {
            winner = 1
        }
        //Player 2 check
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player2.contains(7) && player2.contains(5) && player2.contains(3)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                if (player1.contains(11)) {
                    Toast.makeText(this, "Player 1 Wins ! Press Replay to play again :)", Toast.LENGTH_LONG).show()
                }
                if (player1.contains(12)) {
                    Toast.makeText(this, "Player 2 Wins ! Press Replay to play again :)", Toast.LENGTH_LONG).show()
                }

            }
            else {
                if (player2.contains(11)) {
                    Toast.makeText(this, "Player 1 Wins ! Press Replay to play again :)", Toast.LENGTH_LONG).show()
                }
                if (player2.contains(12)) {
                    Toast.makeText(this, "Player 2 Wins ! Press Replay to play again :)", Toast.LENGTH_LONG).show()
                }
            }
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }

        if (winner == -1 && (player1.size + player2.size) == 11) {
            Toast.makeText(this, "Its a Draw ! Press Replay to play again :)", Toast.LENGTH_LONG).show()
        }

    }
}
