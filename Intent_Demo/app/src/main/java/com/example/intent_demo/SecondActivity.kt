package com.example.intent_demo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var display: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        display=findViewById(R.id.tvDisplay)

        val receivedName =intent.getStringExtra("user_name")
        val receivedSurname=intent.getStringExtra("user_surname")

        display.text=" Hello, $receivedName $receivedSurname!"

    }
}