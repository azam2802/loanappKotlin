package com.example.design1

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Debt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_debt)

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Retrieve the passed text
        val selectedReport = intent.getStringExtra("selected_report")

        // Find the TextView and set its text based on the received value
        val reportTextView = findViewById<TextView>(R.id.tableName) // Replace with your TextView ID
        reportTextView.text = when (selectedReport) {
            "Должники" -> "Должники"
            "Сумма по типу" -> "Сумма по типу"
            "Прибыль"-> "Прибыль"
            "Этот месяц"-> "Этот месяц"
            "Погашено" -> "Погашено"
            "Кредит" -> "Кредит"
            else -> "Unknown selection"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}