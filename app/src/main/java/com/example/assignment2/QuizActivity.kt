package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

data class Question(val text: String, val isHack: Boolean)

object QuestionBank {
    val questions = listOf(
        Question("Phishing is a type of social engineering.", true),
        Question("Using the same password for all accounts is safe.", false),
        Question("Two-factor authentication adds an extra layer of security.", true),
        Question("Public Wi-Fi is always secure.", false),
        Question("Antivirus software can protect your computer from malware.", true)
    )
}

class QuizActivity : AppCompatActivity() {

    private var currentIndex = 0
    private var score = 0
    private val answers = mutableListOf<Boolean>()

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var nextButton: Button
    private lateinit var hackButton: Button
    private lateinit var mythButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        // Initialize UI components
        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        nextButton = findViewById(R.id.nextButton)
        hackButton = findViewById(R.id.hackButton)
        mythButton = findViewById(R.id.mythbutton)

        loadQuestion()

        hackButton.setOnClickListener {
            checkAnswer(true)
        }

        mythButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex < QuestionBank.questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                // Quiz completed, transition to ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", QuestionBank.questions.size)
                intent.putExtra("answers", answers.toBooleanArray())
                
                Log.d("QuizApp", "Final Score: $score")
                
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = QuestionBank.questions[currentIndex].text
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = QuestionBank.questions[currentIndex].isHack
        answers.add(userAnswer)

        if (userAnswer == correctAnswer) {
            score++
            feedbackText.text = "Correct!"
        } else {
            feedbackText.text = "Wrong!"
        }
    }
}
