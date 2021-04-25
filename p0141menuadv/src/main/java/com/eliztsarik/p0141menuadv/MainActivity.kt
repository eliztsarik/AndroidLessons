package com.eliztsarik.p0141menuadv

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var chb: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView)
        chb = findViewById(R.id.chbExtMenu)
        chb.setOnClickListener { onClickCheckbox(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menu.setGroupVisible(R.id.group1, chb.isChecked)
        return super.onPrepareOptionsMenu(menu)
    }

    private fun onClickCheckbox(checkBox: View) {
        tv.text = ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sb = StringBuilder()
        sb.append("Item menu")
        sb.append("\r\n groupId ${item.groupId}")
        sb.append("\r\n itemId ${item.itemId}")
        sb.append("\r\n order ${item.order}")
        sb.append("\r\n title: ${item.title}")

        tv.text = sb.toString()
        return super.onOptionsItemSelected(item)
    }
}