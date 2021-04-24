package com.eliztsarik.p0102activitylistener

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        btnOk.setOnClickListener { onClick(it) }
        btnCancel.setOnClickListener { onClick(it) }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            (R.id.btnOk) -> tvOut.text = "Нажата кнопка Ок"
            (R.id.btnCancel) -> tvOut.text = "Нажата кнопка Cancel"
        }
    }
}