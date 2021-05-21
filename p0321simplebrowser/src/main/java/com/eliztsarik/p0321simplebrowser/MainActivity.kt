package com.eliztsarik.p0321simplebrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnWeb).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ya.ru")))
        }
    }
}