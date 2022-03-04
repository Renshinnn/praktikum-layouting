package www.smktelkommlg.sch.id

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity6 : AppCompatActivity() {

    internal var number:String?=""
    private lateinit var etPhoneNumber: EditText
    private lateinit var btnCall: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnCall = findViewById(R.id.btn_call)


        btnCall.setOnClickListener {
            number = etPhoneNumber.text.toString().trim()
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(number)))
            startActivity(dialIntent)
        }

    }
}