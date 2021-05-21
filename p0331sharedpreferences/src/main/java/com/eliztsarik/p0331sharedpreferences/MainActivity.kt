package com.eliztsarik.p0331sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val SAVED_TEXT = "saved_text"

class MainActivity : AppCompatActivity() {

    lateinit var etText: EditText

    lateinit var sPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etText = findViewById(R.id.etText)

        findViewById<Button>(R.id.btnSave)
            .setOnClickListener { saveText() }
        findViewById<Button>(R.id.btnLoad)
            .setOnClickListener { loadText() }

        loadText()
    }

    private fun saveText() {
        sPref = getPreferences(Context.MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString(SAVED_TEXT, etText.text.toString())
        ed.commit()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadText() {
        sPref = getPreferences(Context.MODE_PRIVATE)
        val savedText = sPref.getString(SAVED_TEXT, "")
        etText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }
}