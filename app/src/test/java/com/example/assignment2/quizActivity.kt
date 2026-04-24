package com.example.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class questionActivity : AppCompatActivity() {

    // keeps track of the current question index
    var = currentIndex = 0

    // stores the users score
     var score = 0

    // UI components
     var questionText: textview
     var feedBack: textView
     var nextButton: Button

     // Link UI elements with XML
     questionText = findViewById(R.id.questionText)
     feedbackText = findViewById(R.id.feedbackText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)



    }
}
