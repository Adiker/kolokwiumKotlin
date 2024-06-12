package com.example.kolokwiumAW

import android.annotation.SuppressLint
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
        binding.buttonOblicz.setOnClickListener()
        {
            bmi()
            ppm()
            cpm()
        }
        binding.buttonHistory.setOnClickListener()
        {
            history()
        }

    }
    @SuppressLint("SuspiciousIndentation")
    private fun bmi()
    {
        var masa = binding.masaText.text.toString().toDouble()
        var wzrost = binding.heightText.text.toString().toDouble()
        var bmi = masa/(wzrost/100).pow(2)
        var bmiText = "Twoje BMI wynosi: %.2f".format(bmi)
        Toast.makeText(this, bmiText, Toast.LENGTH_SHORT).show()
        history.add("BMI: %.2f".format(bmi))
        var info : String = ""

            if (bmi < 16)
            {
                info = "Wygłodzenie"
            }
            else if(bmi >= 16 && bmi <= 16.99)
            {
                info = "Wychudzenie"
            }
            else if(bmi >= 17 && bmi <= 24.99)
            {
                info = "Prawidłowa"
            }
            else if (bmi >= 25 && bmi <= 29.99)
            {
                info = "Nadwaga"
            }
            else if (bmi >= 30 && bmi <= 34.99)
            {
                info = "1 stopień OTYŁOŚCI"
            }
            else if (bmi >= 35 && bmi <= 39.99)
            {
                info = "2 stopień OTYŁOŚCI"
            }
            else if (bmi >= 40)
            {
                info = "OTYŁOŚĆ skrajna"
            }


        Toast.makeText(this,info,Toast.LENGTH_SHORT).show()
    }
    private fun ppm()
    {
        var masa = binding.masaText.text.toString().toDouble()
        var wzrost = binding.heightText.text.toString().toDouble()
        var wiek = binding.ageText.text.toString().toDouble()
        var ppm = (10*masa)+(6.25*wzrost)-(5*wiek)+5
        history.add("PPM: %.2f".format(ppm))
        var info = "Twoje PPM wynosi: %.2f".format(ppm)
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
    }
    private fun cpm()
    {
        var masa = binding.masaText.text.toString().toDouble()
        var wzrost = binding.heightText.text.toString().toDouble()
        var wiek = binding.ageText.text.toString().toDouble()
        var ppm = (10*masa)+(6.25*wzrost)-(5*wiek)+5
        var cpm : Double = 0.0
        var info : String = ""
        if(binding.radioButtonMale.isChecked)
        {
            if(binding.akt1.isChecked)
            {
                cpm = ppm * 1.2
                info = "Brak aktywności"
            }
            else if(binding.akt2.isChecked)
            {
                cpm = ppm * 1.3
                info = "Bardzo lekka aktywność (1 dzień w tygodniu"
            }
            else if(binding.akt3.isChecked)
            {
                cpm = ppm * 1.6
                info = "Lekka aktywność (2-3 dni w tygodniu)"
            }
            else if(binding.akt4.isChecked)
            {
                cpm = ppm * 1.7
                info = "Lekka aktywność (2-3 dni w tygodniu)"
            }
            else if(binding.akt5.isChecked)
            {
                cpm = ppm * 2.1
                info = "Duża aktywność (codziennie)"
            }
            else if(binding.akt6.isChecked)
            {
                cpm = ppm * 2.4
                info = "Bardzo duża aktywność"
            }

        }
        else if(binding.radioButtonFemale.isChecked)
        {
            if(binding.akt1.isChecked)
            {
                cpm = ppm * 1.2
                info = "Brak aktywności"
            }
            else if(binding.akt2.isChecked)
            {
                cpm = ppm * 1.3
                info = "Bardzo lekka aktywność (1 dzień w tygodniu)"
            }
            else if(binding.akt3.isChecked)
            {
                cpm = ppm * 1.5
                info = "Lekka aktywność (2-3 dni w tygodniu)"
            }
            else if(binding.akt4.isChecked)
            {
                cpm = ppm * 1.6
                info = "Lekka aktywność (2-3 dni w tygodniu)"
            }
            else if(binding.akt5.isChecked)
            {
                cpm = ppm * 1.9
                info = "Duża aktywność (codziennie)"
            }
            else if(binding.akt6.isChecked)
            {
                cpm = ppm * 2.2
                info = "Bardzo duża aktywność"
            }
        }
        history.add("CPM: %.2f".format(cpm))
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show()
    }
    private fun history()
    {
        Toast.makeText(this, history.toString(), Toast.LENGTH_SHORT).show()
    }
}