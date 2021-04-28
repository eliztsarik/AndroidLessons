package com.eliztsarik.p0201simpleanimation

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val MENU_ALPHA_ID = 1
const val MENU_SCALE_ID = 2
const val MENU_TRANSLATE_ID = 3
const val MENU_ROTATE_ID = 4
const val MENU_COMBO_ID = 5

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)

        registerForContextMenu(tv)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when (v?.id) {
            R.id.tv -> {
                menu?.add(0, MENU_ALPHA_ID, 0, "alpha")
                menu?.add(0, MENU_SCALE_ID, 0, "scale")
                menu?.add(0, MENU_TRANSLATE_ID, 0, "translate")
                menu?.add(0, MENU_ROTATE_ID, 0, "rotate")
                menu?.add(0, MENU_COMBO_ID, 0, "combo")
            }
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var anim: Animation? = null
        when (item.itemId) {
            MENU_ALPHA_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myalpha)
            MENU_SCALE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myscale)
            MENU_TRANSLATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mytrans)
            MENU_ROTATE_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.myrotate)
            MENU_COMBO_ID -> anim = AnimationUtils.loadAnimation(this, R.anim.mycombo)
        }
        tv.startAnimation(anim)
        return super.onContextItemSelected(item)
    }
}