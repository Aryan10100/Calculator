package com.example.calculatoradvance

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatoradvance.R.*
import com.example.calculatoradvance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private var operation: Char? = null
    private var str1: String = ""
    private var str2: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            one.setOnClickListener { seedNumber("1") }
            two.setOnClickListener { seedNumber("2") }
            three.setOnClickListener { seedNumber("3") }
            four.setOnClickListener { seedNumber("4") }
            five.setOnClickListener { seedNumber("5") }
            six.setOnClickListener { seedNumber("6") }
            seven.setOnClickListener { seedNumber("7") }
            eight.setOnClickListener { seedNumber("8") }
            nine.setOnClickListener { seedNumber("9") }
            zero.setOnClickListener { seedNumber("0") }
            point.setOnClickListener { seedNumber(".") }

            clearText.setOnClickListener {
                if(operation != null) {
                    str1 = ""
                    number1.text = str1
                } else if(str2.isBlank()) {
                    operation = null
                }else {
                    str2 = ""
                    number2.text = str2
                }
            }

            add.setOnClickListener { operation = '+' }
            multiply.setOnClickListener { operation = '*' }
            minus.setOnClickListener { operation = '-' }
            divide.setOnClickListener { operation = '/' }

            equalsTo.setOnClickListener {
                when(operation) {
                    '+' -> { str1 = (str1.toFloat() + str2.toFloat()).toString() }
                    '-' -> { str1 = (str1.toFloat() - str2.toFloat()).toString() }
                    '*' -> { str1 = (str1.toFloat() * str2.toFloat()).toString() }
                    '/' -> { str1 = (str1.toFloat() / str2.toFloat()).toString() }
                }
                number1.text = str1
                str2 = ""
                number2.text = str2
            }

        }
    }

    fun seedNumber(number: String) {
        binding?.apply {
            if (operation != null) {
                str1 += number
                number1.text = str1
            } else {
                str2 += number
                number2.text = str2
            }
        }
    }

}
