package com.eliztsarik.p0291simpleactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NameActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        etName = findViewById(R.id.etName)
        btnOk = findViewById(R.id.btnOK)
        btnOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", etName.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}