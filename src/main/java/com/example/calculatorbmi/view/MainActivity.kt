package com.example.calculatorbmi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorbmi.R
import com.example.calculatorbmi.fragment.CalculatorBmiFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculatorBmiFragment = CalculatorBmiFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, calculatorBmiFragment)
            commit()
        }
    }
}