package com.example.starsuckslogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonRegister: Button
    private lateinit var buttonLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonRegister=findViewById( R.id.btnRegister)
        buttonLogin=findViewById(R.id.btnLogin)

        buttonRegister.setOnClickListener {

            val intent= Intent(this, Login::class.java )

            startActivity(intent)
        }
    }
}