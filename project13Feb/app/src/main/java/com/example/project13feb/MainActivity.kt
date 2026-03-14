package com.example.project13feb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project13feb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.img1.setOnClickListener {
            Toast.makeText(this@MainActivity, "Caramel Frappuccino",
            Toast.LENGTH_LONG).show()
        }

        binding.img2.setOnClickListener {
            Toast.makeText(this@MainActivity, "Vanilla Cappuccino",
                Toast.LENGTH_LONG).show()
        }

        binding.img3.setOnClickListener {
            Toast.makeText(this@MainActivity, "Bottled Chai Latte",
                Toast.LENGTH_LONG).show()
        }

        binding.img4.setOnClickListener {
            Toast.makeText(this@MainActivity, "Rainbow Frappuccino",
                Toast.LENGTH_LONG).show()
        }

        binding.img5.setOnClickListener {
            Toast.makeText(this@MainActivity, "Pumpkin Spice Latte",
                Toast.LENGTH_LONG).show()
        }

        binding.img6.setOnClickListener {
            Toast.makeText(this@MainActivity, "Salted Caramel Latte",
                Toast.LENGTH_LONG).show()
        }
    }
}