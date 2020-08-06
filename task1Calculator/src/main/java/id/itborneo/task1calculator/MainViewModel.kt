package id.itborneo.task1calculator

import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel : ViewModel() {

    fun calculate(buttonString: String, numbers: MutableList<Int>): Long {
        var result = 0L
        when (buttonString) {
            "+" -> {

                result = numbers[0].toLong() + numbers[1].toLong()
            }
            "-"->{
                result = numbers[0].toLong() - numbers[1].toLong()
            }
            "x"->{
                result = numbers[0].toLong() * numbers[1].toLong()
            }
            "/"->{
                result = numbers[0].toLong() / numbers[1].toLong()
            }
        }
        return result
    }


}