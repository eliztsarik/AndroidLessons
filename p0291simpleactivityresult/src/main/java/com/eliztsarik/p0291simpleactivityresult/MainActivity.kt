package com.eliztsarik.p0291simpleactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvName: TextView
    lateinit var btnName: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tvName)
        btnName = findViewById(R.id.btnName)

        btnName.setOnClickListener{
            startActivityForResult(Intent(this, NameActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return
        val name = data.getStringExtra("name")
        tvName.text = "Your name is $name"
        super.onActivityResult(requestCode, resultCode, data)
    }
}