package com.student.quiztest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_quiz.*

class Activity_Math_quiz : AppCompatActivity() {

    private val question: MutableList<QuizData> = ArrayList()

    var questionIndex = 0
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz)

        loadQuizData()
        SetActiveQuestions(questionIndex)
        sumbit_button.setOnClickListener {
            val radioButton = radio_group.checkedRadioButtonId
            if (radioButton == -1) {
                Toast.makeText(applicationContext, "Answer no marked", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val text = radioButton.toString()
            if (text == question[questionIndex].question1)
                score++
            score_ball.text = score.toString()
            if (questionIndex >= question.size - 1) {
                //Toast.makeText(applicationContext, "GAME OVER!", Toast.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("GAME OVER")
                builder.setMessage("RESULT $score")
                builder.setMessage("EXIT GAME")


                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    finishAffinity()

                }

                builder.setNegativeButton("No") { dialog, which ->
                    restargame()
                }

                builder.show()
            } else {
                radio_group.clearCheck()
                SetActiveQuestions(++questionIndex)
            }

        }


    }

    fun loadQuizData() {
        question.add(
            QuizData(
                "The wages of 10 workers for a six-day week is \$ 1200. What are the one day’s wages of 4 workers?",
                "$ 40",
                "$ 32",
                "$ 80",
                "$ 24",
                "$ 80"
            )
        )

        question.shuffle()
    }

    fun SetActiveQuestions(index: Int) {

        quiz_kotlin.text = question[index].question1
        rb_1.text = question[index].option1
        rb_2.text = question[index].option2
        rb_3.text = question[index].option3
        rb_4.text = question[index].option4
        question1.text = (index + 1).toString()
        score_ball.text = score.toString()

    }

    fun restargame() {
        questionIndex = 0
        score = 0
        radio_group.clearCheck()
        question.shuffle()
        score_ball.text = score.toString()
        SetActiveQuestions(questionIndex)
        question1.text = (questionIndex + 1).toString()


    }
}