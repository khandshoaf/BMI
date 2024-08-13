package com.example.calculatorbmi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.calculatorbmi.R
import com.example.calculatorbmi.controller.CalculatorBmiController

class CalculatorBmiFragment : Fragment(R.layout.fragment_calculator_bmi) {

    private lateinit var btnCalculator: Button
    private lateinit var edtAge: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtWeight: EditText
    private lateinit var btnDelete: Button
    private lateinit var controller: CalculatorBmiController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edtAge = view.findViewById(R.id.edtAge)
        edtHeight = view.findViewById(R.id.edtHeight)
        edtWeight = view.findViewById(R.id.edtWeight)
        btnCalculator = view.findViewById(R.id.btn_calculator)
        btnDelete = view.findViewById(R.id.btn_delete)

        controller = CalculatorBmiController(
            edtAge,
            edtHeight,
            edtWeight
        )
        controller.setFragmentManager(requireActivity().supportFragmentManager)
        controller.setContext(requireContext())

        btnDelete.setOnClickListener {
            controller.clearInputFields()
        }

        btnCalculator.setOnClickListener {
            controller.calculatorBMI()
        }
    }
}