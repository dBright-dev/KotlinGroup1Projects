package com.example.intent

import java.io.Serializable

data class User(val name: String,
                val age: Int,
                val salary: Double,
                val isStudent: Boolean,
                val interests: ArrayList<String>
): Serializable
