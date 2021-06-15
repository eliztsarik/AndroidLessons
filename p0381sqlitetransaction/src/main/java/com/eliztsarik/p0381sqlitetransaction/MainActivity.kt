package com.eliztsarik.p0381sqlitetransaction

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {
    lateinit var dbh: DBHelper
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "--- onCreate Activity ---");
        dbh = DBHelper(this)
        myActionsWithBlock()
    }

    private fun myActions() {
        db = dbh.writableDatabase
        delete(db, "mytable")
        db.beginTransaction()
        insert(db, "mytable", "val1")
        db.setTransactionSuccessful()
        insert(db, "mytable", "val2")
        db.endTransaction()
        insert(db, "mytable", "val3")
        read(db, "mytable")
        dbh.close()
    }

    private fun myActionsWithBlock() {
        val table = "mytable"
        try {
            db = dbh.writableDatabase
            delete(db, table)

            db.beginTransaction()
            insert(db, table, "val1")

            Log.d(LOG_TAG, "create DBHelper")
            val dbh2 = DBHelper(this)
            Log.d(LOG_TAG, "get db")
            val db2 = dbh2.writableDatabase
            read(db2, table)

            db.setTransactionSuccessful()
            db.endTransaction()
            read(db, table)
            dbh.close()
        } catch (e: Exception) {
            Log.d(LOG_TAG, "${e.javaClass} error: ${e.message} ")
        }
    }

    private fun read(db: SQLiteDatabase, table: String) {
        Log.d(LOG_TAG, "Read table $table");
        val c = db.query("mytable", null, null, null, null, null, null)
        c?.let {
            Log.d(LOG_TAG, "Records count = ${c.count}")
            if (c.moveToFirst()) {
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")))
                } while (c.moveToNext())
            }
            it.close()
        }
    }

    private fun insert(db: SQLiteDatabase, table: String, value: String) {
        Log.d(LOG_TAG, "Insert in table $table value = $value");
        val cv = ContentValues()
        cv.put("val", value)
        db.insert(table, null, cv)
    }

    private fun delete(db: SQLiteDatabase, table: String) {
        Log.d(LOG_TAG, "Delete all from table $table");
        db.delete(table, null, null)
    }

    open class DBHelper(context: Context) : SQLiteOpenHelper(context, "myDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            db.execSQL(
                """create table mytable(
                |id integer primary key autoincrement,
                |val text
                |);""".trimMargin()
            )
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }
}