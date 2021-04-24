package com.eliztsarik.p0091onclickbuttons

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity() {

    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel) //ASK: autochanging to needed type?

        btnOk.setOnClickListener {
            tvOut.text =
                "Нажата кнопка ОК" //ASK: in Java we need to override onClick, here if we need to set same actions, we only need to create new func, and apply it here?
        }

        btnCancel.setOnClickListener {
            tvOut.text = "Нажата кнопка Cancel"
        }
    }
}