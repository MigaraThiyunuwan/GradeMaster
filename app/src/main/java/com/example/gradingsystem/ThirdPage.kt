package com.example.gradingsystem

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_page)

        val buttonBack: Button = findViewById(R.id.backbutton)
        buttonBack.setOnClickListener {
            finish()
        }

        val subjects = listOf("mad", "is", "apt", "adbms", "hci", "es", "cg", "dns")
        for (subject in subjects) {
            val grade = intent.getStringExtra(subject)
            val textView = findViewById<TextView>(resources.getIdentifier("grade_$subject", "id", packageName))
            textView.text = grade
        }

    }

}