package com.example.intent

import android.content.Intent //Intent is used to move between activities.
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { //Creates the first screen of the app.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //Calls parent code.
        enableEdgeToEdge()

       var binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Shows layout on screen.

        binding.buttonSend.setOnClickListener { //Runs when button is pressed. Everything inside brackets run after click.

            val name=binding.txtName.text.toString()

           val age= if(binding.txtAge.text.toString().isNotEmpty()) //Check if empty, if empty use 0, If not convert to Int
           {
               binding.txtAge.text.toString().toInt()
           }
            else
            {
                0
            }

            val salary= if(binding.txtSalary.text.toString().isNotEmpty())
                binding.txtSalary.text.toString().toDouble() else 0.0

            val isStudent =binding.checkBoxStudent.isChecked
            val interests= ArrayList<String>()
            if(binding.checkBoxMusic.isChecked)interests.add("Music")
            if(binding.checkBoxSports.isChecked)interests.add("Sports")
            if(binding.checkBoxReading.isChecked)interests.add("Reading")
            if(binding.checkBoxTravel.isChecked)interests.add("Travel")

            val user= User(name, age, salary, isStudent, interests)

            val intent= Intent(this, SecondActivity::class.java) // Intent = go from MainActivity → SecondActivity.

            intent.putExtra("user_name", name)
            intent.putExtra("user_age", age)
            intent.putExtra("user_salary", salary)
            intent.putExtra("user_is_student", isStudent)
            intent.putStringArrayListExtra("user_interests", interests)
            intent.putExtra("user_object", user)
            startActivity(intent)



        }
    }


}