package ru.n0maCi.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.btn_0).setOnClickListener { setTextFields("0") }
        findViewById<TextView>(R.id.btn_1).setOnClickListener { setTextFields("1") }
        findViewById<TextView>(R.id.btn_2).setOnClickListener { setTextFields("2") }
        findViewById<TextView>(R.id.btn_3).setOnClickListener { setTextFields("3") }
        findViewById<TextView>(R.id.btn_4).setOnClickListener { setTextFields("4") }
        findViewById<TextView>(R.id.btn_5).setOnClickListener { setTextFields("5") }
        findViewById<TextView>(R.id.btn_6).setOnClickListener { setTextFields("6") }
        findViewById<TextView>(R.id.btn_7).setOnClickListener { setTextFields("7") }
        findViewById<TextView>(R.id.btn_8).setOnClickListener { setTextFields("8") }
        findViewById<TextView>(R.id.btn_9).setOnClickListener { setTextFields("9") }
        findViewById<TextView>(R.id.dot_btn).setOnClickListener { setTextFields(".") }
        findViewById<TextView>(R.id.minus_btn).setOnClickListener { setTextFields("-") }
        findViewById<TextView>(R.id.plus_btn).setOnClickListener { setTextFields("+") }
        findViewById<TextView>(R.id.mult_btn).setOnClickListener { setTextFields("*") }
        findViewById<TextView>(R.id.divide_btn).setOnClickListener { setTextFields("/") }
        findViewById<TextView>(R.id.open_btn).setOnClickListener { setTextFields("(") }
        findViewById<TextView>(R.id.close_btn).setOnClickListener { setTextFields(")") }
        findViewById<TextView>(R.id.clear_btn).setOnClickListener {
            findViewById<TextView>(R.id.math_operation).text = ""
            findViewById<TextView>(R.id.result_text).text = ""
        }
        findViewById<TextView>(R.id.back_btn).setOnClickListener {
            val str = findViewById<TextView>(R.id.math_operation).text.toString()
            if(str.isNotEmpty())
                findViewById<TextView>(R.id.math_operation).text = str.substring(0, str.length - 1)
            findViewById<TextView>(R.id.result_text).text = ""
        }
        findViewById<TextView>(R.id.equal_btn).setOnClickListener {
            try {
                val ex = ExpressionBuilder(findViewById<TextView>(R.id.math_operation).text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    findViewById<TextView>(R.id.result_text).text = longRes.toString()
                else
                    findViewById<TextView>(R.id.result_text).text = result.toString()
            } catch(e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if(findViewById<TextView>(R.id.result_text).text != "") {
            findViewById<TextView>(R.id.math_operation).text = findViewById<TextView>(R.id.result_text).text
            findViewById<TextView>(R.id.result_text).text = ""
        }
        findViewById<TextView>(R.id.math_operation).append(str)
    }
}