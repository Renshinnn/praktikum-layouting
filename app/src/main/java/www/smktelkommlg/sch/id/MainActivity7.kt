package www.smktelkommlg.sch.id

import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioGroup
import android.os.Bundle
import www.smktelkommlg.sch.id.R
import android.content.Intent
import android.view.View
import android.widget.Button
import www.smktelkommlg.sch.id.MainActivity7

class MainActivity7 : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra selected value"
        const val RESULT_CODE = 110
    }

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        btnChoose = findViewById(R.id.btn_choose)

        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }


    }
}