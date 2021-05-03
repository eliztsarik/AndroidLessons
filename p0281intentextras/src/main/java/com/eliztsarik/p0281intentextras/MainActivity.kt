package com.eliztsarik.p0281intentextras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var etFName: EditText
    lateinit var etLName: EditText

    lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener{onBtnSubmitClick()}
    }

    private fun onBtnSubmitClick() {
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("fname", etFName.text.toString())
        intent.putExtra("lname", etLName.text.toString())
        startActivity(intent)
    }


}