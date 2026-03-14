package com.example.categories01vpptgrp12026

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.categories01vpptgrp12026.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val categories=mutableListOf<Category>()
    private lateinit var adapter: ArrayAdapter<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter= ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            categories)
        binding.listView.adapter=adapter
        binding.btnCategory.setOnClickListener{
            showAddCategoryDialog()
        }
        binding.btnItems.setOnClickListener {
            showAddItemDialog()

        }

    }
    private fun showAddItemDialog() {
        if(categories.isEmpty()) {

            Toast.makeText(this,
                "No Categories Available",
                Toast.LENGTH_SHORT).show()
            return
        }
        val categoryNames=categories.map { it.name }.toTypedArray()

        AlertDialog.Builder(this).setTitle("Select Category").setItems(categoryNames)
        { _, which ->
            val selectedCategory = categories[which]
            showItemInputDialog (selectedCategory)
        }.show()

    }

    fun showItemInputDialog(selectedCategory: Category)
    {
        val input= EditText(this)
        AlertDialog.Builder(this)
            .setTitle("Add item to ${selectedCategory.name}")
            .setView(input)
            .setPositiveButton("Add"){_,_ ->
                val itemName=input.text.toString()
                if (itemName.isNotEmpty())
                {
                    selectedCategory.items.add(itemName)
                    adapter.notifyDataSetChanged()
                }
            }.setNegativeButton("Cancel", null)
            .show()

    }

    private fun showAddCategoryDialog()
    {
        val input= EditText(this)
        AlertDialog.Builder(this)
            .setTitle("Add Category")
            .setView(input)
            .setPositiveButton("Add"){_,_ ->
                val categoryName=input.text.toString()
                if(categoryName.isNotEmpty()){
                    categories.add(Category(categoryName))
                    adapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()

    }
}