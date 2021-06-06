package com.eliztsarik.p0361sqlitequery

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG = "my Logs"

class MainActivity : AppCompatActivity() {

    val name = arrayOf(
        "Китай", "США", "Бразилия", "Россия", "Япония",
        "Германия", "Египет", "Италия", "Франция", "Канада"
    )
    val people = arrayOf(1400, 311, 195, 142, 128, 82, 80, 60, 66, 35)
    val region = arrayOf(
        "Азия", "Америка", "Америка", "Европа", "Азия",
        "Европа", "Африка", "Европа", "Европа", "Америка"
    )

    lateinit var etFunc: EditText
    lateinit var etPeople: EditText
    lateinit var etRegionPeople: EditText
    lateinit var rgSort: RadioGroup

    lateinit var dbHelper: DBHelper
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAll)
            .setOnClickListener {
                Log.d(LOG_TAG, "--- Все записи ---")
                DBRequest()
            }

        findViewById<Button>(R.id.btnFunc)
            .setOnClickListener {
                val sFunc = etFunc.text.toString()
                Log.d(LOG_TAG, "--- Функций $sFunc ---")
                DBRequest(columns = arrayOf(sFunc))
                etFunc.text.clear()
            }

        findViewById<Button>(R.id.btnGroup)
            .setOnClickListener {
                Log.d(LOG_TAG, "--- Население по региону ---");
                DBRequest(columns = arrayOf("region", "sum(people) as people"), groupBy = "region")
            }

        findViewById<Button>(R.id.btnHaving)
            .setOnClickListener {
                Log.d(LOG_TAG, "---  ---")
                val sRegionPeople = etRegionPeople.text.toString()
                DBRequest(
                    columns = arrayOf("region", "sum(people) as people"),
                    groupBy = "region",
                    having = "sum(people) > $sRegionPeople"
                )
                etRegionPeople.text.clear()
            }

        findViewById<Button>(R.id.btnPeople)
            .setOnClickListener {
                val sPeople = etPeople.text.toString()
                Log.d(LOG_TAG, "--- Регионы с населением больше $sPeople ---")
                DBRequest(selection = "people > ?", selectionArgs = arrayOf(sPeople))
                etPeople.text.clear()
            }

        findViewById<Button>(R.id.btnSort)
            .setOnClickListener {
                when (rgSort.checkedRadioButtonId) {
                    R.id.rName -> {
                        Log.d(LOG_TAG, "--- Сортировка по наименованию ---")
                        DBRequest(orderBy = "name")
                    }
                    R.id.rPeople -> {
                        Log.d(LOG_TAG, "--- Сортировка по населению ---")
                        DBRequest(orderBy = "people")
                    }
                    R.id.rRegion -> {
                        Log.d(LOG_TAG, "--- Сортировка по региону ---")
                        DBRequest(orderBy = "region")
                    }
                }
            }

        etFunc = findViewById(R.id.etFunc)
        etRegionPeople = findViewById(R.id.etRegionPeople)
        etPeople = findViewById(R.id.etPeople)

        rgSort = findViewById(R.id.rgSort)

        dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        val c = db.query("mytable", null, null, null, null, null, null)
        if (c.count == 0) {
            val cv = ContentValues()
            for (i in 0..9) {
                cv.put("name", name[i])
                cv.put("people", people[i])
                cv.put("region", region[i])
                Log.d(LOG_TAG, "id = " + db.insert("mytable", null, cv))
            }
        }
        c.close()
        dbHelper.close()
        findViewById<Button>(R.id.btnAll).performClick()
    }


    private fun DBRequest(
        columns: Array<String>? = null,
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        groupBy: String? = null,
        having: String? = null,
        orderBy: String? = null
    ) {
        db = dbHelper.writableDatabase
        var c: Cursor? = null

        c = db.query("mytable", columns, selection, selectionArgs, groupBy, having, orderBy)

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    var str = ""
                    for (cn in c.columnNames) {
                        str += "$cn = ${c.getString(c.getColumnIndex(cn))}; "
                    }
                    Log.d(LOG_TAG, str)
                } while (c.moveToNext())
            }
            c.close()
        } else {
            Log.d(LOG_TAG, "Cursor is null")
        }
        db.close()
    }



    class DBHelper(context: Context) : SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate DataBase ---")
            db.execSQL(
                """
                create table mytable(
                id integer primary key autoincrement,
                name text,
                people integer,
                region text
                );"""
            )
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }
    }
}