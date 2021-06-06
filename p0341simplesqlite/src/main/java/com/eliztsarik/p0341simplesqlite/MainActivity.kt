package com.eliztsarik.p0341simplesqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etID: EditText

    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAdd)
            .setOnClickListener { onAdd() }

        findViewById<Button>(R.id.btnClear)
            .setOnClickListener { onClean() }

        findViewById<Button>(R.id.btnRead)
            .setOnClickListener { onRead() }

        findViewById<Button>(R.id.btnUpd)
            .setOnClickListener { onUpdate(it) }

        findViewById<Button>(R.id.btnDel)
            .setOnClickListener { onDelete(it) }

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etID = findViewById(R.id.etID)

        dbHelper = DBHelper(this)
    }

    private fun onDelete(view: View) {
        val id = etID.text.toString()
        if (id == "") {
            return
        }
        val db = dbHelper.writableDatabase
        Log.d(LOG_TAG, "--- Delete from mytable: ---")
        val delCount = db.delete("mytable", "id = $id", null)
        Log.d(LOG_TAG, "deleted rows count = $delCount")
    }

    private fun onUpdate(view: View) {
        val id = etID.text.toString()
        if (id == "") {
            return
        }
        Log.d(LOG_TAG, "--- Update mytable: ---")
        val cv = ContentValues()
        val db = dbHelper.writableDatabase

        val name = etName.text.toString()
        val email = etEmail.text.toString()


        cv.put("name", name)
        cv.put("email", email)

        val updCount = db.update("mytable", cv, "id = ?", arrayOf(id))
        Log.d(LOG_TAG, "updated rows count = $updCount");
    }

    private fun onAdd() {
        val cv = ContentValues()
        val db = dbHelper.writableDatabase

        val name = etName.text.toString()
        val email = etEmail.text.toString()

        Log.d(LOG_TAG, "--- Insert in mytable: ---")
        cv.put("name", name)
        cv.put("email", email)
        val rowId = db.insert("mytable", null, cv)
        Log.d(LOG_TAG, "rows inserted, ID = $rowId")

        db.close()
    }

    private fun onRead() {
        val db = dbHelper.writableDatabase

        Log.d(LOG_TAG, "--- Rows in mytable: ---")
        val c = db.query("mytable", null, null, null, null, null, null)
        if (c.moveToFirst()) {
            val idColIndex = c.getColumnIndex("id")
            val nameColIndex = c.getColumnIndex("name")
            val emailColIndex = c.getColumnIndex("email")

            do {
                Log.d(LOG_TAG, "ID = ${c.getInt(idColIndex)}, name = ${c.getString(nameColIndex)}, email = ${c.getString(emailColIndex)}")
            } while (c.moveToNext())
        } else {
            Log.d(LOG_TAG, "0 rows were found")
        }
        c.close()

        db.close()
    }

    private fun onClean() {
        val db = dbHelper.writableDatabase

        Log.d(LOG_TAG, "--- Clear mytable: ---")
        val clearCount = db.delete("mytable", null, null)
        Log.d(LOG_TAG, "deleted rows count = $clearCount")

        db.close()
    }

    class DBHelper(context: Context): SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate DataBase ---")
            db.execSQL("""
                create table mytable(
                id integer primary key autoincrement,
                name text,
                email text
                );
            """.trimIndent())
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }
    }
}