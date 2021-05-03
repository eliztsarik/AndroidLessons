package com.eliztsarik.p026intentfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityDateEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val sdf = SimpleDateFormat("EEE, MMM d, yyyy", Locale("ru","RU"))
        val time = sdf.format(Date(System.currentTimeMillis()))
        val tvDate = findViewById<TextView>(R.id.tvDate)
        tvDate.text = time
    }
}