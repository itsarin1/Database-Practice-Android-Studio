package com.example.praktikum3.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DatabaseHelper(context: Context) : SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "latihan.sqlite3"
        private const val DATABASE_VERSION = 1
        private const val TABLE_PROFILE = "profile"
        private const val COLUMN_NIM = "nim"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_DEVICE_ID = "device_id"
    }

    // Fungsi tambahan untuk memastikan tabel ada
    private fun ensureTableExists(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_PROFILE ($COLUMN_NIM TEXT PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_DEVICE_ID TEXT)")
    }

    fun insertOrUpdateProfile(nim: String, name: String, deviceId: String) {
        val db: SQLiteDatabase = writableDatabase
        ensureTableExists(db)

        val values = ContentValues().apply {
            put(COLUMN_NIM, nim)
            put(COLUMN_NAME, name)
            put(COLUMN_DEVICE_ID, deviceId)
        }

        val cursor = db.rawQuery("SELECT * FROM $TABLE_PROFILE WHERE $COLUMN_NIM = ?", arrayOf(nim))

        if (cursor.count > 0) {
            db.update(TABLE_PROFILE, values, "$COLUMN_NIM = ?", arrayOf(nim))
        } else {
            db.insert(TABLE_PROFILE, null, values)
        }
        cursor.close()
    }

    fun readData(query: String): Cursor? {
        return try {
            val db = readableDatabase
            ensureTableExists(db) // Pastikan tabel ada sebelum baca
            db.rawQuery(query, null)
        } catch (e: Exception) {
            null
        }
    }
}