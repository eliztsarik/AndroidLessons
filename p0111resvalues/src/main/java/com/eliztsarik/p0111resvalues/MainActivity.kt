package com.eliztsarik.p0111resvalues

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llBottom = findViewById<LinearLayout>(R.id.llBottom)
        val tvBottom = findViewById<TextView>(R.id.tvBottom)
        val btnBottom = findViewById<Button>(R.id.btnBottom)

        llBottom.setBackgroundResource(R.color.llBottomColor)
        tvBottom.setText(R.string.tvBottomText)
        btnBottom.setText(R.string.btnBottomText)
        resources.getString(R.string.app_name)
    }
}