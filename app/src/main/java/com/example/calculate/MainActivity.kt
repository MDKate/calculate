package com.example.calculate

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculate.R.layout.activity_main
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val math_operation = findViewById<TextView>(R.id.math_operation)
        val math_result = findViewById<TextView>(R.id.math_result)


        val number_0 = findViewById<TextView>(R.id.number_0)
        number_0.setOnClickListener { setTextFields("0") }
        val number_1 = findViewById<TextView>(R.id.number_1)
        number_1.setOnClickListener { setTextFields("1") }
        val number_2 = findViewById<TextView>(R.id.number_2)
        number_2.setOnClickListener { setTextFields("2") }
        val number_3 = findViewById<TextView>(R.id.number_3)
        number_3.setOnClickListener { setTextFields("3") }
        val number_4 = findViewById<TextView>(R.id.number_4)
        number_4.setOnClickListener { setTextFields("4") }
        val number_5 = findViewById<TextView>(R.id.number_5)
        number_5.setOnClickListener { setTextFields("5") }
        val number_6 = findViewById<TextView>(R.id.number_6)
        number_6.setOnClickListener { setTextFields("6") }
        val number_7 = findViewById<TextView>(R.id.number_7)
        number_7.setOnClickListener { setTextFields("7") }
        val number_8 = findViewById<TextView>(R.id.number_8)
        number_8.setOnClickListener { setTextFields("8") }
        val number_9 = findViewById<TextView>(R.id.number_9)
        number_9.setOnClickListener { setTextFields("9") }
        val action_subtract = findViewById<TextView>(R.id.action_subtract)
        action_subtract.setOnClickListener { setTextFields("-") }
        val action_sum = findViewById<TextView>(R.id.action_sum)
        action_sum.setOnClickListener { setTextFields("+") }
        val action_multiply = findViewById<TextView>(R.id.action_multiply)
        action_multiply.setOnClickListener { setTextFields("*") }
        val action_share = findViewById<TextView>(R.id.action_share)
        action_share.setOnClickListener { setTextFields("/") }
        val action_bracket_left = findViewById<TextView>(R.id.action_bracket_left)
        action_bracket_left.setOnClickListener { setTextFields("(") }
        val action_bracket_right = findViewById<TextView>(R.id.action_bracket_right)
        action_bracket_right.setOnClickListener { setTextFields(")") }
        val number_point = findViewById<TextView>(R.id.number_point)
        number_point.setOnClickListener { setTextFields(".") }

        val action_AC = findViewById<TextView>(R.id.action_AC)
        action_AC.setOnClickListener {
            math_operation.text = ""
            math_result.text = ""
        }

        val number_erase = findViewById<TextView>(R.id.number_erase)
        number_erase.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            math_result.text = ""
        }

        val action_equality = findViewById<TextView>(R.id.action_equality)
        action_equality.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longResult = result.toLong()
                if (result == longResult.toDouble())
                   math_result.text = longResult.toString()
                else
                    math_result.text = result.toString()
            }catch (e:Exception) {
                Log.d("Ошибка","сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String){
      val math_operation = findViewById<TextView>(R.id.math_operation)
      val math_result = findViewById<TextView>(R.id.math_result)
        if (math_result.text != "")
            math_operation.text = math_result.text
            math_result.text = ""
        math_operation.append(str)
    }
}




