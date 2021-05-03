package com.eliztsarik.p0301activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button

class AlignActivity : AppCompatActivity() {

    lateinit var btnLeft: Button
    lateinit var btnCenter: Button
    lateinit var btnRight: Button

    private val newIntent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)

        btnLeft = findViewById(R.id.btnLeft)
        btnCenter = findViewById(R.id.btnCenter)
        btnRight = findViewById(R.id.btnRight)

        btnLeft.setOnClickListener { sendResult(Gravity.LEFT) }
        btnCenter.setOnClickListener { sendResult(Gravity.CENTER) }
        btnRight.setOnClickListener { sendResult(Gravity.RIGHT) }

    }

    private fun sendResult(alignment: Int) {
        newIntent.putExtra("alignment", alignment)
        setResult(Activity.RESULT_OK, newIntent)
        finish()

    }
}