package com.student.quiztest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_quiz.*

class Activity_kotlin_quiz : AppCompatActivity() {

    private val question: MutableList<QuizData> = ArrayList()

    var questionIndex = 0
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_quiz)

        loadQuizData()
        SetActiveQuestions(questionIndex)
        sumbit_button.setOnClickListener {
            val radioButton = radio_group.checkedRadioButtonId
            if (radioButton == -1) {
                Toast.makeText(applicationContext, "Answer no marked", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val text = radioButton.toString()
            if (radio_group.checkedRadioButtonId.toString() == question[questionIndex].answer)
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
                " What is a correct syntax to output \"Hello World\" in Kotlin?",
                "System.out.printline(\"Hello World\")",
                "println(\"Hello World\")",
                "Console.WrtieLine(\"Hello World\")",
                "cout>>\"Hello World\";",
                "println(\"Hello World\")"
            )
        )
        question.add(
            QuizData(
                "How do you insert COMMENTS in Kotlin code?",
                "/*This is a comment",
                "/#This is a comment",
                "//This is a comment",
                "--This is a comment",
                "//This is a comment",
            )
        )
        question.add(
            QuizData(
                "Which keyword is used to declare a function?",
                "function",
                "fun",
                "decl",
                "define",
                "fun"
            )
        )
        question.add(
            QuizData(
                "How can you create a variable with the numeric value 5?",
                "num=5",
                "val num=5",
                "int num=5",
                "val=5 int",
                "val num=5"
            )
        )
        question.add(
            QuizData(
                "How can you create a variable with the floating number 2.8?",
                "double num = 2.8",
                "val num = 2.8",
                "num = 2.8 float",
                "float num = 2.8",
                "val num = 2.8"
            )
        )
        question.add(
            QuizData(
                "Which operator is used to add together two values?",
                "The * sign",
                "The & sign",
                "The ADD keyword",
                "The + sign  ",
                "The + sign"
            )
        )
        question.add(
            QuizData(
                "Which operator can be used to compare two values?",
                "< >",
                "==",
                "=",
                "< >",
                "=="
            )
        )
        question.add(
            QuizData(
                "Which symbol is used for string templates/interpolation?",
                "&",
                ".",
                "*",
                "$",
                "$"
            )
        )
        question.add(
            QuizData(
                "To create an array in Kotlin, use",
                "The arrayOf() function",
                "None of the above",
                "{}",
                "[]",
                "The arrayOf() function"
            )
        )
        question.add(
            QuizData(
                "How do you call a function in Kotlin?",
                "myFunction;",
                "myFunction()",
                "myFunction[]",
                "(myFunction)",
                "myFunction()"
            )
        )
        question.add(
            QuizData(
                "Which keyword is used to return a value inside a function?",
                "break",
                "get",
                "return",
                "vod",
                "return"
            )
        )
        question.add(
            QuizData(
                "How do you start writing a for loop in Kotlin, to loop through arrays?",
                "for x",
                "for (x in y)",
                "for x in y",
                "for (x)",
                "for (x in y)"
            )
        )
        question.add(
            QuizData(
                "How can you create a range of numbers between 5 and 15 in Kotlin?",
                "for (5 to 15",
                "for (x in 5..15)",
                "for (5..15)",
                "for (x in 5 to 15)",
                "for (x in 5..15)"
            )
        )
        question.add(
            QuizData(
                "Which statement is used to stop a loop?",
                "exit",
                "void",
                "break",
                "stop",
                "break"
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