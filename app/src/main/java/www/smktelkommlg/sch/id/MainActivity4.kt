package www.smktelkommlg.sch.id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        if(intent!=null){
            val tvData1: TextView = findViewById(R.id.tv_data1)
            val tvData2: TextView = findViewById(R.id.tv_data2)

            tvData1.text = intent.getStringExtra("data1")
            tvData2.text = intent.getStringExtra("data2")

        }

}
}