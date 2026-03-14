package com.example.intent_demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnExplicit.setOnClickListener {
            val editName=binding.edtName.text.toString()
            val editSurname=binding.edtSurname.text.toString()

            val intent= Intent(this,
                SecondActivity::class.java)
            intent.putExtra("user_name", editName)
            intent.putExtra("user_surname", editSurname)
            startActivity(intent)
        }
    }
}