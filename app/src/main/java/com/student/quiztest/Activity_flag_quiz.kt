package com.student.quiztest

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_flag.*
import java.util.*

class Activity_flag_quiz : AppCompatActivity() {

    private val quizFlag = QuizFlag()
    val images = quizFlag.flagimage
    val options = quizFlag.options


    var correctAnswers = ""

    var questionNumber = 1

    var score = 0

    private val levels = 12


    private val generatedQuestions: MutableList<Int> = ArrayList()

    private val generatedOptions: MutableList<Int> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)
        generateQustions()

        rb_1.setOnClickListener {
//            rb_1.bac
        }


        sumbit_button.setOnClickListener {

            val idRadioButton = radio_group.checkedRadioButtonId
            when (idRadioButton) {


                R.id.rb_1 -> {
                    if (correctAnswers == rb_1.text.toString())
                        score++
                }
                R.id.rb_2 -> {
                    if (correctAnswers == rb_2.text.toString())
                        score++
                }
                R.id.rb_3 -> {
                    if (correctAnswers == rb_3.text.toString())
                        score++
                }
                R.id.rb_4 -> {
                    if (correctAnswers == rb_4.text.toString())
                        score++
                }
                else -> {
                    showToast("Answer not marked")
                }

            }
            if (questionNumber >= levels) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("GAME OVER")
                builder.setMessage("RESULT $score")


                builder.setPositiveButton(android.R.string.yes) { dialog, which ->


                }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->

                }

                builder.show()

            } else if (idRadioButton > 0)
                questionNumber++
            generateQustions()
        }
    }

    private fun generateQustions() {
        generatedOptions.clear()
        //12 bosqichdan iborat
        if (questionNumber < levels + 1) {
            radio_group.clearCheck()
            question.text = questionNumber.toString()
            score_ball.text = score.toString()
        }
        val randomObj = Random()
        var random: Int = randomObj.nextInt(images.size)
        while (random in generatedQuestions) {
            random = (images.indices).random()

        }
        generatedQuestions.add(random)
        image_flag.setImageResource(images[random])
        correctAnswers = options[random]

        val radioButtons = listOf<Int>(
            R.id.rb_1,
            R.id.rb_2,
            R.id.rb_3,
            R.id.rb_4
        )

        val correctRandomPosition = randomObj.nextInt(radioButtons.size)
        val radioButton = findViewById<RadioButton>(radioButtons[correctRandomPosition])
        radioButton.text = correctAnswers

        for (i in 0..radioButtons.lastIndex) {

            if (i == correctRandomPosition)
                continue

            val radioButton = findViewById<RadioButton>(radioButtons[i])
            random = randomObj.nextInt(options.size)

            while (random in generatedQuestions || options[random] == correctAnswers) {

                random = randomObj.nextInt(options.size)
            }
            generatedQuestions.add(random)
            radioButton.text = options[random]


        }
    }

    private fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}