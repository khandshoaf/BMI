package com.example.calculatorbmi.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.calculatorbmi.R

class ResultFragment : Fragment(R.layout.fragment_result) {
    private lateinit var bmiResultTextView: TextView
    private lateinit var statusBmi: TextView
    private lateinit var healthyWeight: TextView
    private lateinit var bmiBasic: TextView
    private lateinit var ponderal: TextView
    private lateinit var imgBack: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bmiResultTextView = view.findViewById(R.id.txt_resultBmi)
        statusBmi = view.findViewById(R.id.txt_statusBmi)
        healthyWeight = view.findViewById(R.id.txt_standardWeight)
        bmiBasic = view.findViewById(R.id.txt_bmiBasic)
        ponderal = view.findViewById(R.id.txt_poderal)
        imgBack = view.findViewById(R.id.img_back)

        val underWeight = getString(R.string.underWeight)
        val normal = getString(R.string.normal)
        val overWeight = getString(R.string.overWeight)
        val preObese = getString(R.string.preObese)
        val obeseClass1 = getString(R.string.obese1)
        val obeseClass2 = getString(R.string.obese2)
        val obeseClass3 = getString(R.string.obese3)

        val bmi = arguments?.getDouble("bmi")
        val lowerHealthyWeight = arguments?.getDouble("lowerWeight")
        val upperHealthyWeight = arguments?.getDouble("upperWeight")
        val basicBmi = arguments?.getDouble("bmiBasic")
        val ponderalIndex = arguments?.getDouble("ponderal")
        val text = "$lowerHealthyWeight - $upperHealthyWeight"
        if (bmi != null) {
            when {
                bmi < 18.5 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = underWeight
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi in 18.5..22.9 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = normal
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi in 23.0..24.9 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = overWeight
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi in 25.0..29.9 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = preObese
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi in 30.0..34.9 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = obeseClass1
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi in 35.0..39.9 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = obeseClass2
                    statusBmi.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.orangeBrown
                        )
                    )
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }

                bmi >= 40 -> {
                    bmiResultTextView.text = bmi.toString()
                    statusBmi.text = obeseClass3
                    statusBmi.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                    healthyWeight.text = text
                    bmiBasic.text = basicBmi.toString()
                    ponderal.text = ponderalIndex.toString()
                }
            }
        }

        imgBack.setOnClickListener {
            val calculatorFragment = CalculatorBmiFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, calculatorFragment)
                .commit()
        }
    }
}