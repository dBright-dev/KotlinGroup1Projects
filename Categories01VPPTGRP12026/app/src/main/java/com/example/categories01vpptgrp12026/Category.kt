package com.example.categories01vpptgrp12026

data class Category(val name:String,
                    val items: MutableList<String> =mutableListOf())
{
    override fun toString(): String {
        return if (items.isEmpty()){
            "$name(No items)"
        }
        else{
            "$name:\n -"+ items.joinToString ( "\n -s" )

        }
    }
}