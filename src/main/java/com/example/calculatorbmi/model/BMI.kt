package com.example.calculatorbmi.model

class BMI(private val height: Double, private val weight: Double) {
    fun calculateBMI(): Double {
        val heightInMeter = height / 100
        val bmi = weight / (heightInMeter * heightInMeter)
        return kotlin.math.round(bmi * 10.0) / 10.0
    }

    fun calculateLowerHealthyWeight(): Double {
        val heightInMeter = height / 100
        val lowerWeight = 18.5 * heightInMeter * heightInMeter
        return kotlin.math.round(lowerWeight * 10.0) / 10.0
    }

    fun calculateUpperHealthyWeight(): Double {
        val heightInMeter = height / 100
        val upperWeight = 25 * heightInMeter * heightInMeter
        return kotlin.math.round(upperWeight * 10.0) / 10.0
    }

    fun calculatorBmiBasic(): Double {

        val bmiBasic = calculateBMI() / 25
        return kotlin.math.round(bmiBasic * 10.0) / 10.0
    }

    fun calculatePoderal(): Double {
        val heightInMeter = height / 100
        val ponderal = weight / (heightInMeter * heightInMeter * heightInMeter)
        return kotlin.math.round(ponderal * 10.0) / 10.0
    }
}