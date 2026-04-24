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
    var nextButton: Button  .

    // Link UI elements with XML
    questionText = findViewById(R.id.questionText)
    feedbackText = findViewById(R.id.feedbackText)
    nextButton = findViewBy(R.id.nextButton)

    val hackButton = findViewById<button>(R.id.hackButton)
    val mythbutton = findViewById<Button>(R.id.mythbutton)

    // Load the first question when activity starts
    loadQuestion()

    // set click listeners for answer buttons
    hackbutton.setOnClickListener
    { checkAnswer(true) }
    mythutton.setOnclickListener
    { checkAnswer(false) }

    // Move to next question when Button is clicked
    nextButton.setOnClickListener
    {
        currentIndex++

        // check if there are more questions
        if (currentIndex < QuestionBank.question.size)
    }
    loadQuestion()
    feedbackText.text = ""
 } else {

     // navigate to result screen when quiz ends
     val intent = intent("this", ResultActivity::class.java )
    intent.putExtra("score", score)
    intent.putExtra("total",quetionBank.questionBank.question.size)
    intent.putExtra("answes", answers, answers.tobooleanArray(  ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)



    }
}
