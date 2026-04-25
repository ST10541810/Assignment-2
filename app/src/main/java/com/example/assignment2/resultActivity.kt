package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val scoreText = findViewById<TextView>(R.id.scoreText)
        val messageText = findViewById<TextView>(R.id.messageText)
        val restartButton = findViewById<Button>(R.id.restartButton)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        scoreText.text = "Score: $score / $total"

        messageText.text = if (score > total / 2) {
            "Master Hacker!"
        } else {
            "Keep practicing!"
        }

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
