package com.eliztsarik.p0301activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ColorActivity : AppCompatActivity() {

    lateinit var btnRed: Button
    lateinit var btnGreen: Button
    lateinit var btnBlue: Button

    private val newIntent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        btnRed = findViewById(R.id.btnRed)
        btnGreen = findViewById(R.id.btnGreen)
        btnBlue = findViewById(R.id.btnBlue)

        btnRed.setOnClickListener {
            sendResult(Color.RED)
        }
        btnGreen.setOnClickListener {
            sendResult(Color.GREEN)
        }

        btnBlue.setOnClickListener {
            sendResult(Color.BLUE)
        }
    }

    private fun sendResult(color: Int) {
        newIntent.putExtra("color", color)
        setResult(Activity.RESULT_OK, newIntent)
        finish()

    }
}