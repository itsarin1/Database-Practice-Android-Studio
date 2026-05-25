package com.example.praktikum3

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikum3.database.DatabaseHelper

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNIM)
        val etDeviceId = findViewById<EditText>(R.id.etDeviceId)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        val sharedPref = applicationContext.getSharedPreferences("latihan2", Context.MODE_PRIVATE)

        etNama.setText(sharedPref.getString("name", ""))
        etNim.setText(sharedPref.getString("nim", ""))
        etDeviceId.setText(sharedPref.getString("deviceId", ""))

        btnSimpan.setOnClickListener {
            val name = etNama.text.toString().trim()
            val nim = etNim.text.toString().trim()
            val deviceId = etDeviceId.text.toString().trim()

            // Simpan ke SharedPreferences
            val editSharedPref = sharedPref.edit()
            editSharedPref.putString("name", name)
            editSharedPref.putString("nim", nim)
            editSharedPref.putString("deviceId", deviceId)
            editSharedPref.apply()

            // Simpan ke SQLite
            val dbHelper = DatabaseHelper(this)
            dbHelper.insertOrUpdateProfile(nim, name, deviceId)

            Toast.makeText(this, "Tersimpan ke databases: $name", Toast.LENGTH_LONG).show()

            finish()
        }
    }
}