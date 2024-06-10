package com.example.kolokwiumAW

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kolokwiumAW.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val history = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonBmi.setOnClickListener()
        {
            bmi()
        }
        binding.buttonHistory.setOnClickListener()
        {
            history()
        }

    }
    private fun bmi()
    {
        var masa = binding.masaText.text.toString().toDouble()
        var wzrost = binding.heightText.text.toString().toDouble()
        var bmi = masa/(wzrost/100).pow(2)
        var bmiText = "Twoje BMI wynosi: %.2f".format(bmi)
        Toast.makeText(this, bmiText, Toast.LENGTH_SHORT).show()
        history.add("%.2f".format(bmi))
        var info : String = ""
        if (binding.radioButtonFemale.isChecked)
        {
            if (bmi < 19)
            {
                info = "Niedowaga"
            }
            else if(bmi >= 19 && bmi < 24)
            {
                info = "Waga prawidłowa"
            }
            else if(bmi >= 24 && bmi < 29)
            {
                info = "Nadwaga"
            }
            else if (bmi >= 29 && bmi < 39)
            {
                info = "OTYŁOŚĆ, OGARNIJ SIE"
            }
        }
        else if (binding.radioButtonMale.isChecked)
        {
            if (bmi < 20)
            {
                info = "Niedowaga"
            }
            else if(bmi >= 20 && bmi < 25)
            {
                info = "Waga prawidłowa"
            }
            else if(bmi >= 25 && bmi < 30)
            {
                info = "Nadwaga"
            }
            else if (bmi >= 30 && bmi < 40)
            {
                info = "Otyłość"
            }
        }
        Toast.makeText(this,info,Toast.LENGTH_SHORT).show()
    }
    private fun history()
    {
        Toast.makeText(this, history.toString(), Toast.LENGTH_SHORT).show()
    }
}