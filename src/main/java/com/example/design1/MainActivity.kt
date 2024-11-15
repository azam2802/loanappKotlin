package com.example.design1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main);
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.type_autoComplete)
        val textInputLayout = findViewById<TextInputLayout>(R.id.type_input)

        // List of items for the dropdown
        val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")

        // Create the ArrayAdapter and set it for the AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, options)
        autoCompleteTextView.setAdapter(adapter)

        // Set an OnClickListener to open the dropdown when clicked
        autoCompleteTextView.setOnClickListener {
            autoCompleteTextView.showDropDown()  // Manually show the dropdown
        }

        // Optionally set an item click listener to handle item selection
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedOption = parent.getItemAtPosition(position) as String
            // Handle the selected item here
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


