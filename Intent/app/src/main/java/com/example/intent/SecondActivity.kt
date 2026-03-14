/*package com.example.intent

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "DefaultLocale")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding= ActivitySecondBinding.inflate(layoutInflater)
       // setContentView(R.layout.activity_second)
        setContentView(binding.root)
        val textName=binding.textName
        val textAge=binding.textAge
        val textSalary=binding.textSalary
        val textIsStudent=binding.textIsStudent
        val textInterests=binding.textInterests
        val textUserObject=binding.textUserObject
        val back=binding.buttonBack

        //get data from intent
        val name = intent.getStringExtra("user_name")
        val age= intent.getIntExtra("user_age", 0)
        val salary = intent.getDoubleExtra("user_salary", 0.0)
        val isStudent = intent.getBooleanExtra("user_is_student", false)
        val interest = intent.getStringArrayListExtra("user_interests")

        val userObject = if(android.os.Build.VERSION.SDK_INT>= android.os.Build.VERSION_CODES.TIRAMISU)
        {
            intent.getSerializableExtra("user_object", User::class.java)
        }
        else{
            @Suppress("DEPRECIATION")
            intent.getSerializableExtra("user_object")as? User
        }
       val userObject = intent.getSerializableExtra("user_object", User::class.java)

        textName.text="Name: $name"
        textAge.text="Age: $age"
        textSalary.text="Salary: $${String.format("%.2f", salary)}"
        textIsStudent.text="Is Student: ${if(isStudent) "Yes" else "No"}"
        textInterests.text="Interests: $interest"
        textUserObject.text="User Object Data: \n" + "Name: ${userObject?.name}," +
                "Age: ${userObject?.age}, Salary:${userObject?.salary}, Interests: ${userObject?.interests?.joinToString(", ")}"
            }
}*/


//CHAT
package com.example.intent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() { //This creates the second screen of the app.

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) { //This function runs when the screen opens.
        super.onCreate(savedInstanceState) //Calls the parent class code.

        val binding = ActivitySecondBinding.inflate(layoutInflater) //This creates the ViewBinding object, to access views like this binding.textName instead of using findViewById
        setContentView(binding.root)  //shows the layout on the screen.

        // These get references to the TextViews.
        val textName = binding.textName
        val textAge = binding.textAge
        val textSalary = binding.textSalary
        val textIsStudent = binding.textIsStudent
        val textInterests = binding.textInterests
        val textUserObject = binding.textUserObject

        // Get data from intent.
        val name = intent.getStringExtra("user_name")
        val age = intent.getIntExtra("user_age", 0) //if nothing is found use 0
        val salary = intent.getDoubleExtra("user_salary", 0.0) //if nothing is found use 0.0
        val isStudent = intent.getBooleanExtra("user_is_student", false)
        val interest = intent.getStringArrayListExtra("user_interests")

        //NB: Only works because User implements Serializable.
        val userObject = intent.getSerializableExtra("user_object") as? User //get object and convert to User safely

        // set text on screen
        textName.text = "Name: $name"
        textAge.text = "Age: $age"
        textSalary.text = "Salary: $salary"
        textIsStudent.text = "Is Student: $isStudent"
        textInterests.text = "Interests: $interest"

        textUserObject.text =
            "User Object:\n" +
                    "Name: ${userObject?.name}\n" + //?. means to only use if not null to prevent crashesssss
                    "Age: ${userObject?.age}\n" +
                    "Salary: ${userObject?.salary}\n" +
                    "Interests: ${userObject?.interests}"
    }
}