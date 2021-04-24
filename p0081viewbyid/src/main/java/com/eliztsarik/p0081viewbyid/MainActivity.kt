package com.eliztsarik.p0081viewbyid

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView = findViewById<TextView>(R.id.myText)
        myTextView.text = "New text in TextView"

        val myBtn = findViewById<Button>(R.id.myBtn)
        myBtn.text = "Oh my button"
        myBtn.isEnabled = false

        val myChb = findViewById<CheckBox>(R.id.myChb)
        myChb.isChecked = true;
    }
}