package com.eliztsarik.p0171dynamiclayout2

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var llMain: LinearLayout
    lateinit var rgGravity: RadioGroup
    lateinit var etName: EditText
    lateinit var btnCreate: Button
    lateinit var btnClear: Button

    var wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llMain = findViewById(R.id.llMain)
        rgGravity = findViewById(R.id.rgGravity)
        etName = findViewById(R.id.etName)

        btnCreate = findViewById(R.id.btnCreate)
        btnCreate.setOnClickListener { onClick(it) }

        btnClear = findViewById(R.id.btnClear)
        btnClear.setOnClickListener { onClick(it) }
    }

    private fun onClick(view: View) {
        when (view.id) {
            R.id.btnCreate -> {
                val lParams = LinearLayout.LayoutParams(wrapContent, wrapContent)
                var btnGravity = Gravity.LEFT;
                when (rgGravity.checkedRadioButtonId) {
                    R.id.rbLeft -> btnGravity = Gravity.LEFT
                    R.id.rbCenter -> btnGravity = Gravity.CENTER_HORIZONTAL
                    R.id.rbRight -> btnGravity = Gravity.RIGHT
                }
                lParams.gravity = btnGravity

                val btnNew = Button(this)
                println(etName.text)
                println(etName.text.toString())
                btnNew.text = etName.text.toString()
                btnNew.layoutParams = lParams
                llMain.addView(btnNew)
            }
            R.id.btnClear -> {
                llMain.removeAllViews();
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}