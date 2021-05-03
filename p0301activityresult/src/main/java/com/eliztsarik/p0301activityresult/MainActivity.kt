package com.eliztsarik.p0301activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val REQUEST_CODE_COLOR = 1
const val REQUEST_CODE_ALIGN = 2

class MainActivity : AppCompatActivity() {

    lateinit var tvText: TextView
    lateinit var btnColor: Button
    lateinit var btnAlign: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        btnColor = findViewById(R.id.btnColor)
        btnAlign = findViewById(R.id.btnAlign)

        btnColor.setOnClickListener {
            startActivityForResult(Intent(this, ColorActivity::class.java), REQUEST_CODE_COLOR)
        }
        btnAlign.setOnClickListener {
            startActivityForResult(Intent(this, AlignActivity::class.java), REQUEST_CODE_ALIGN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("myLogs", "requestCode = $requestCode, resultCode = $resultCode")
        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "Wrong Result", Toast.LENGTH_LONG).show()
            return
        }
        when (requestCode) {
            REQUEST_CODE_COLOR -> {
                val color = data?.getIntExtra("color", Color.WHITE)
                tvText.setTextColor(color!!)
            }
            REQUEST_CODE_ALIGN -> {
                val align = data?.getIntExtra("alignment", Gravity.LEFT)
                tvText.gravity = align!!
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}