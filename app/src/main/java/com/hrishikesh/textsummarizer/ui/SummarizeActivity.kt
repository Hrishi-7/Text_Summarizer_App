package com.hrishikesh.textsummarizer.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.hrishikesh.textsummarizer.R
import com.hrishikesh.textsummarizer.model.Text2Summary

class SummarizeActivity : AppCompatActivity() {

    private lateinit var txtInput : EditText
    private lateinit var maxSent : EditText
    private lateinit var btnForward : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summarize)

        txtInput = findViewById(R.id.txtInput)
        maxSent = findViewById(R.id.maxSent)
        btnForward = findViewById(R.id.btnForward)

        btnForward.setOnClickListener {
            if(maxSent.text.isNullOrBlank()){
                Toast.makeText(this, "Enter the compression ratio", Toast.LENGTH_LONG).show()
            }else{
                if(txtInput.text.isNullOrBlank()){
                    Toast.makeText(this, "Enter the Sentence", Toast.LENGTH_LONG).show()
                }else{
                    val compressionRatio = maxSent.text.toString().toFloat()
                    if(compressionRatio > 1 || compressionRatio < 0){
                        Toast.makeText(this, "Compression rate should be between 0 and 1", Toast.LENGTH_LONG).show()
                    }else{
                        val summary = Text2Summary.summarize(txtInput.text.toString(), compressionRatio)
                        val intent = Intent(this, SummarizedActivity::class.java)
                        intent.putExtra("Summarized", summary)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}