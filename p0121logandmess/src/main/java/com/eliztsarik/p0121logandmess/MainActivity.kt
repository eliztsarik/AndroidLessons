package com.eliztsarik.p0121logandmess

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button
    val TAG = "MyLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "найдем View элементы")
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        Log.d(TAG, "присваиваем обработчик кнопкам")
        btnOk.setOnClickListener { onClick(it) }
        btnCancel.setOnClickListener { onClick(it) }
    }

    fun onClick(view: View) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        when (view.id) {
            (R.id.btnOk) -> {
                Log.d(TAG, "кнопка ОК")
                tvOut.text = "Нажата кнопка Ок"
                Toast.makeText(this, "Нажата кнопка Ок", Toast.LENGTH_LONG).show()
            }
            (R.id.btnCancel) -> {
                Log.d(TAG, "кнопка Cancel")
                tvOut.text = "Нажата кнопка Cancel"
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show()
            }
        }
    }

}