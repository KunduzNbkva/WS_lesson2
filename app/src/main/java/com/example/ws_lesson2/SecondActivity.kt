package com.example.ws_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var email: String
    lateinit var emailView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        email = intent.getStringExtra("email").toString()
        emailView = findViewById(R.id.email_txt)
        emailView.text = "$email!"
    }
}