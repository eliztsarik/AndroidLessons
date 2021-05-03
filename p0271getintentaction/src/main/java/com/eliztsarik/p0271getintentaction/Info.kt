package com.eliztsarik.p0271getintentaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)

        val action = intent.action
        var format = ""
        var textInfo = ""

        when (action) {
            "com.eliztsarik.intent.action.showtime" -> {
                format = "HH:mm:ss"
                textInfo = "Time"
            }
            "com.eliztsarik.intent.action.showdate" -> {
                format = "dd.MM.yyyy"
                textInfo = "Date"
            }
        }

        val sdf = SimpleDateFormat(format, Locale("ru", "RU"))
        val dateTime = sdf.format(Date(System.currentTimeMillis()))
        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = "${textInfo}: ${dateTime}"
    }
}