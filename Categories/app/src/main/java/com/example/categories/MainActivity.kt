package com.example.categories

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.categories.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    private val categories=mutableListOf<Category>()
    private lateinit var adapter: ArrayAdapter<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1, categories)

        binding.listView.adapter=adapter
        binding.btnCategory.setOnClickListener {
            showAddCategoryDialog()
        }
        binding.btnItems.setOnClickListener {
            showAddItemDialog()
        }



    }

    private fun showAddItemDialog() {

    }

    private fun showAddCategoryDialog() {

    }
}