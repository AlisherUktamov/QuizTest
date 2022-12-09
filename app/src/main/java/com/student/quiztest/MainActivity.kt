package com.student.quiztest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flag_quiz.setOnClickListener {
            val intent = Intent(this, Activity_flag_quiz::class.java)
            startActivity(intent)
        }
        Kotlin_quiz.setOnClickListener {
            val intent = Intent(this, Activity_kotlin_quiz::class.java)
            startActivity(intent)


        }
    }
}