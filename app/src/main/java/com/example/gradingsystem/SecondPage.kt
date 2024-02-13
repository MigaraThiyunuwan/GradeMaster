package com.example.gradingsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_page)

        val buttonBack: Button = findViewById(R.id.buttonback1)
        val checkgrade: Button = findViewById(R.id.checkgrade)
        val errormsg: TextView = findViewById(R.id.errormsg)
        val errorMessage = intent.getStringExtra("errorMessage")

        if (errorMessage != null) {
            errormsg.text = errorMessage
        }

        buttonBack.setOnClickListener {
            finish()
        }

        val subjects = listOf("mad", "is", "apt", "adbms", "hci", "es", "cg", "dns")
        val grades = mutableMapOf<String, String>()
        val intent = Intent(this, ThirdPage::class.java)
        var hasInvalidMarks = false

        checkgrade.setOnClickListener {

            for (subject in subjects) {
                val editText = findViewById<EditText>(resources.getIdentifier(subject, "id", packageName))
                val marks = editText.text.toString().toInt()

                if (marks < 0 || marks > 100 ) {
                    hasInvalidMarks = true
                    break
                }
                grades[subject] = calculateGrade(marks)
            }

            if (hasInvalidMarks) {
                val intent2 = Intent(this@SecondPage, SecondPage::class.java)
                intent2.putExtra("errorMessage", "Please enter valid Marks Again!")
                startActivity(intent2)

            } else {
                for ((subject, grade) in grades) {
                    intent.putExtra(subject, grade)
                }
                startActivity(intent)
            }
        }

    }
    private fun calculateGrade(marks: Int): String {
        return when {
            marks >= 85 -> "A+"
            marks >= 70 -> "A"
            marks >= 65 -> "A-"
            marks >= 60 -> "B+"
            marks >= 55 -> "B"
            marks >= 50 -> "B-"
            marks >= 45 -> "C+"
            marks >= 40 -> "C"
            marks >= 35 -> "C-"
            marks >= 30 -> "D+"
            marks >= 25 -> "D"
            else -> "E"
        }
    }

}