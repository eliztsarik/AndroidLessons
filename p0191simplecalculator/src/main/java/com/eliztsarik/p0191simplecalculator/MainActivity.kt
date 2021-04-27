package com.eliztsarik.p0191simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val MENU_RESET_ID = 1
const val MENU_QUIT_ID = 2

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var etNum1: EditText
    lateinit var etNum2: EditText

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMult: Button
    lateinit var btnDiv: Button

    lateinit var tvResult: TextView
    var oper = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, MENU_RESET_ID, 0, "Reset")
        menu?.add(0, MENU_QUIT_ID, 0, "Quit")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_RESET_ID -> {
                etNum1.text.clear()
                etNum2.text .clear()
                tvResult.text = ""
            }
            MENU_QUIT_ID -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun findViews() {
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)

        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var result = 0F

        if (etNum1.text.toString().isEmpty() || etNum2.text.toString().isEmpty()) return

        val num1 = etNum1.text.toString().toFloat()
        val num2 = etNum2.text.toString().toFloat()

        when (v?.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }
            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }
            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }
            R.id.btnDiv -> {
                if (num2 == 0F) {
                    tvResult.text = ""
                    Toast.makeText(this, "Деление на 0 невозможно", Toast.LENGTH_LONG).show()
                    return
                }
                oper = "/"
                result = num1 / num2
            }
        }

        tvResult.text = "$num1 $oper $num2 = $result"

    }
}