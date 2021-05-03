package com.eliztsarik.p026intentfilter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnTime = findViewById<Button>(R.id.btnTime)
        val btnDate = findViewById<Button>(R.id.btnDate)

        btnTime.setOnClickListener{
            startActivity(Intent("com.eliztsarik.intent.action.showtime"))
        }
        btnDate.setOnClickListener{
            startActivity(Intent("com.eliztsarik.intent.action.showdate"))
        }
    }
}