package com.example.gradingsystem

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)

        val buttonBack: Button = findViewById(R.id.backtohome)

        buttonBack.setOnClickListener {
            finish()
        }

    }
}