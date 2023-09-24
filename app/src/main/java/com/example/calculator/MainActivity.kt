package com.example.calculator

import Addition
import Calculator
import Division
import Multiplication
import Substraction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marks: Array<Char> = arrayOf('+', '-', '×', '÷')

        var mark = false
        var active = true
        var empty = true
        var comma = false

        var first: Double = 0.0
        var second: Double = 0.0

        val div: Division = Division()
        val mul: Multiplication = Multiplication()
        val sub: Substraction = Substraction()
        val add: Addition = Addition()

        val actions: Array<Calculator> = arrayOf(div, mul, sub, add)

        button_clear.setOnClickListener {
            input.text = "0"

            mark = false
            active = true
            empty = true
            comma = false
        }

        button_clear_all.setOnClickListener {
            input.text = "0"
            output.text = ""

            mark = false
            active = true
            empty = true
            comma = false
        }

        button_back.setOnClickListener {
            if (active && !empty)
                input.text = input.text.subSequence(0, input.text.length - 1)
            if (input.text == "") {
                input.text = "0"
                empty = true
            }
        }

        fun clearInput() {
            input.text = "0"

            mark = false
            active = true
            empty = true
            comma = false
        }

        button_division.setOnClickListener {
            if(output.text.isNotEmpty() && marks.contains(output.text[output.text.length - 1]))
            {
                output.text.subSequence(0, output.text.length - 1)
                second = first
                first = div.Calculate(second, input.text.toString().toDouble())
                input.text = first.toString()
            }

            first = input.text.toString().toDouble()
            output.text = addToInputText("÷")

            clearInput()
        }

        button_multiplication.setOnClickListener {
            if(output.text.isNotEmpty() && marks.contains(output.text[output.text.length - 1]))
            {
                output.text.subSequence(0, output.text.length - 1)
                second = first
                first = mul.Calculate(second, input.text.toString().toDouble())
                input.text = first.toString()
            }

            first = input.text.toString().toDouble()
            output.text = addToInputText("×")

            clearInput()
        }

        button_substraction.setOnClickListener {
            if(output.text.isNotEmpty() && marks.contains(output.text[output.text.length - 1]))
            {
                output.text.subSequence(0, output.text.length - 1)
                second = first
                first = sub.Calculate(second, input.text.toString().toDouble())
                input.text = first.toString()
            }

            first = input.text.toString().toDouble()
            output.text = addToInputText("-")

            clearInput()
        }

        button_addition.setOnClickListener {
            if(output.text.isNotEmpty() && marks.contains(output.text[output.text.length - 1]))
            {
                output.text.subSequence(0, output.text.length - 1)
                second = first
                first = add.Calculate(second, input.text.toString().toDouble())
                input.text = first.toString()
            }

            first = input.text.toString().toDouble()
            output.text = addToInputText("+")

            clearInput()
        }

        button_plus_minus.setOnClickListener {
            if (!empty) {
                if (!mark) {
                    input.text = "-${input.text}"
                    mark = true
                } else {
                    input.text = input.text.subSequence(1, input.text.length)
                    mark = false
                }
            }
        }

        button_comma.setOnClickListener {
            if (!comma) {
                input.text = addToInputText(".")
                comma = true
                empty = false
            }
        }

        button_equals.setOnClickListener {
            if(output.text.isNotEmpty() && marks.contains(output.text[output.text.length - 1]))
            {
                second = first
                var action = actions.first { x -> x.sign == output.text[output.text.length - 1] }
                first = action.Calculate(second, input.text.toString().toDouble())
                output.text = first.toString()
                clearInput()
                input.text = output.text
            }
        }

        button_0.setOnClickListener {
            if (!empty)
                input.text = addToInputText("0")
        }

        button_1.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("1")
            empty = false
        }

        button_2.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("2")
            empty = false
        }

        button_3.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("3")
            empty = false
        }

        button_4.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("4")
            empty = false
        }

        button_5.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("5")
            empty = false
        }

        button_6.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("6")
            empty = false
        }

        button_7.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("7")
            empty = false
        }

        button_8.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("8")
            empty = false
        }

        button_9.setOnClickListener {
            if (empty) input.text = ""
            input.text = addToInputText("9")
            empty = false
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }
}