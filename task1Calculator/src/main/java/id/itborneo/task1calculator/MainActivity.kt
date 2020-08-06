package id.itborneo.task1calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var viewModel: MainViewModel

    private val numbers = mutableListOf(0, 0)
    private var indexNumbers = 0

    lateinit var choosedMath: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MainViewModel()

        setupNumbersButton()

        setupMathButton()

    }


    private fun calculate(button: Button) {

        val result = viewModel.calculate(button.text.toString(), numbers)

        tvResult.text = result.toString()

        numbers[0] = tvResult.text.toString().toInt()
        numbers[1] = 0

    }

    private fun updateText(text: String) {
        tvAllNumber.text = " ${tvAllNumber.text.toString() + text}"


    }


    private fun setupNumbersButton() {
        buttonMath =  mutableListOf(btnAdd, btnMinus, btnMultiple, btnDivide)

        val buttonNumbers = mutableListOf<Button>(
            btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0
        )

        buttonNumbers.forEach {
            it.setOnClickListener { v ->
                if(indexNumbers == 0){
                    enableMathButton(true)

                }

                Log.d(TAG, "btn_number+${it.text}")
                val numberString: String = numbers[indexNumbers].toString() + it.text.toString()
                Log.d(TAG, "btn_number string+${numberString}")

                numbers[indexNumbers] = numberString.toInt()
                updateText(it.text.toString())
                Log.d(TAG, "btn_number number  +$numbers")

            }
        }

    }

    lateinit var buttonMath :MutableList<Button>
    private fun setupMathButton() {
        enableMathButton(false)


        buttonMath.forEach {
            it.setOnClickListener { v ->
                indexNumbers = 1

                choosedMath = it
                updateText(it.text.toString())

                enableMathButton(false)

            }
        }

        btnEqual.setOnClickListener {
            calculate(choosedMath)
            enableMathButton(true)


        }

        btnClear.setOnClickListener {
            enableMathButton(false)

            numbers[0] = 0
            numbers[1] = 0
            indexNumbers = 0
            tvAllNumber.text = ""
            tvResult.text = ""

        }
    }

    private fun enableMathButton(enable: Boolean) {
        if(buttonMath[0].isEnabled == enable) return

        buttonMath.forEach {
            it.isEnabled = enable
        }


    }
}