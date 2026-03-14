package com.example.categories

data class Category(val name:String,
                    val items: MutableList<String> =mutableListOf())
