package com.example.praktikum3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val btnProfil = findViewById<Button>(R.id.btnProfil)
        val btnKomentar = findViewById<Button>(R.id.btnKomentar)

        btnProfil.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnKomentar.setOnClickListener {
            startActivity(Intent(this, PostCommentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = applicationContext.getSharedPreferences("latihan2", Context.MODE_PRIVATE)
        val nama = sharedPref.getString("name", "...")
        textView.text = "Selamat Datang \n$nama"
    }
}