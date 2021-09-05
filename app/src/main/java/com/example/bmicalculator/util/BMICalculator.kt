package com.example.bmicalculator.util

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

object BMICalculator {

    var gender: String = "male"
    var age: Int = 20
    var height: Int = 170
    var weight: Int = 62
    var bmi: Double = 0.0



    fun CalculateBMI() {
        bmi = (weight / (height.toDouble() / 100).pow(2.0)).roundOff()

    }

    private fun Double.roundOff(): Double {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(this).toDouble()
    }

    val bmiString: String
        get() = bmi.toString()

    val result: String
        get() = when {
            bmi < 18.5 -> "Underweight"
            bmi in (18.5..24.9) -> "Normal"
            bmi in (24.9..29.9) -> "Overweight"
            else -> "Obesity"
        }
}