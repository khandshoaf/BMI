package com.example.calculatorbmi.controller

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.calculatorbmi.R
import com.example.calculatorbmi.fragment.ResultFragment
import com.example.calculatorbmi.model.BMI

class CalculatorBmiController(
    private val edtAge: EditText,
    private val edtHeight: EditText,
    private val edtWeight: EditText,
) {

    private lateinit var parentFragmentManager: FragmentManager
    private lateinit var context: Context

    fun setFragmentManager(fragmentManager: FragmentManager) {
        this.parentFragmentManager = fragmentManager
    }

    fun setContext(applicationContext: Context) {
        this.context = applicationContext
    }

    fun clearInputFields() {
        edtAge.setText("")
        edtHeight.setText("")
        edtWeight.setText("")
    }

    fun calculatorBMI() {
        val ageUse = edtAge.text.toString()
        val heightUser = edtHeight.text.toString()
        val weightUser = edtWeight.text.toString()
        if (ageUse.isNotEmpty() && heightUser.isNotEmpty() && weightUser.isNotEmpty()) {
            val age = ageUse.toInt()
            val height = heightUser.toDouble()
            val weight = weightUser.toDouble()
            if (age in 2..120) {
                if (height > 0 && weight > 0) {
                    val bmiCalculator = BMI(height, weight)
                    val bmi = bmiCalculator.calculateBMI()
                    val lowerHealthyWeight = bmiCalculator.calculateLowerHealthyWeight()
                    val upperHealthyWeight = bmiCalculator.calculateUpperHealthyWeight()
                    val bmiBasic = bmiCalculator.calculatorBmiBasic()
                    val ponderal = bmiCalculator.calculatePoderal()

                    val bundle = Bundle()
                    bundle.putDouble("bmi", bmi)
                    bundle.putDouble("lowerWeight", lowerHealthyWeight)
                    bundle.putDouble("upperWeight", upperHealthyWeight)
                    bundle.putDouble("bmiBasic", bmiBasic)
                    bundle.putDouble("ponderal", ponderal)
                    val resultFragment = ResultFragment()
                    resultFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, resultFragment)
                        .commit()
                } else {
                    Toast.makeText(
                        context,
                        "Cân nặng hoặc chiều cao không hợp lệ",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            } else {
                Toast.makeText(context, "Vui lòng nhập tuổi hợp lệ", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(context, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT)
                .show()
        }
    }
}