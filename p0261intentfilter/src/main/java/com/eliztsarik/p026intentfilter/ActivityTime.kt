package com.eliztsarik.p026intentfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val sdf = SimpleDateFormat("HH:mm:ss", Locale("ru","RU"))
        val time = sdf.format(Date(System.currentTimeMillis()))
        val tvTime = findViewById<TextView>(R.id.tvTime)
        tvTime.text = time

    }
}