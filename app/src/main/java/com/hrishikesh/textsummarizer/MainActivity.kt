package com.hrishikesh.textsummarizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.hrishikesh.textsummarizer.ui.SummarizeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed(3000){
            val intent = Intent(this, SummarizeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}