package com.example.praktikum3

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PostCommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_comment)

        val etComment = findViewById<EditText>(R.id.etKomentar)
        val btnKirim = findViewById<Button>(R.id.btnKirim)

        val sharedPref = applicationContext.getSharedPreferences("latihan2", Context.MODE_PRIVATE)
        val deviceId = sharedPref.getString("deviceId", "")

        btnKirim.setOnClickListener {
            val komentar = etComment.text.toString()
            if (komentar.isNotEmpty()) {
                Toast.makeText(this, "Pesan dari $deviceId: $komentar", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Isi komentar!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}