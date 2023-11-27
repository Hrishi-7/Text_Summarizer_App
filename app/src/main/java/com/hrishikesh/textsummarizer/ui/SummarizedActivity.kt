package com.hrishikesh.textsummarizer.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.hrishikesh.textsummarizer.R

class SummarizedActivity : AppCompatActivity() {
    private lateinit var txtSummarized : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summarized)

        txtSummarized = findViewById(R.id.txtSummarized)

        val summary = intent.extras?.getString("Summarized")
        txtSummarized.setText(summary)

    }
}