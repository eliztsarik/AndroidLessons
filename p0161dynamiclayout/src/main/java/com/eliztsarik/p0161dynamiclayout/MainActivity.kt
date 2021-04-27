package com.eliztsarik.p0161dynamiclayout

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linLayout = LinearLayout(this)
        linLayout.orientation = LinearLayout.VERTICAL
        val linLayoutParam = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setContentView(linLayout, linLayoutParam)

        val lpView = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        val tv = TextView(this)
        tv.text = "TextView"
        tv.layoutParams = lpView
        linLayout.addView(tv)

        val btn = Button(this)
        btn.text = "Button"
        linLayout.addView(btn, lpView)

        val leftMarginParams =
            LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        leftMarginParams.leftMargin = 50

        val btn1 = Button(this)
        btn1.text = "Button1"
        linLayout.addView(btn1, leftMarginParams)

        val rightGravityParam =
            LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        rightGravityParam.gravity = Gravity.RIGHT
        val btn2 = Button(this)
        btn2.text = "Button2"
        linLayout.addView(btn2, rightGravityParam)
    }
}