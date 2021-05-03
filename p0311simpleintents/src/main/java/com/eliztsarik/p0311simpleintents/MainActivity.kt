package com.eliztsarik.p0311simpleintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnWeb: Button
    lateinit var btnMap: Button
    lateinit var btnCall: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWeb = findViewById(R.id.btnWeb)
        btnMap = findViewById(R.id.btnMap)
        btnCall = findViewById(R.id.btnCall)

        btnWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com")))
        }

        btnMap.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("geo:55.754283,37.62002")
            startActivity(intent)
        }

        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:12345")
            startActivity(intent)
        }

    }
}