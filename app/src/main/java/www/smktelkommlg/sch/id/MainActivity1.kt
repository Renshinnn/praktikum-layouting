package www.smktelkommlg.sch.id

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.MainThread

class MainActivity1 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveSV: Button = findViewById(R.id.btn_move_sv)
        btnMoveSV.setOnClickListener(this)

        val btnMoveActivityData: Button = findViewById(R.id.btn_move_with_data)
        btnMoveActivityData.setOnClickListener(this)

        val btnMoveActivityObject: Button = findViewById(R.id.btn_move_with_objek)
        btnMoveActivityObject.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity1, MainActivity2::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_sv -> {
                val moveSV = Intent(this@MainActivity1, MainActivity3::class.java)
                startActivity(moveSV)
            }
            R.id.btn_move_with_data -> {
                val intent = Intent(this@MainActivity1, MainActivity4::class.java)
                intent.putExtra("data1", "somestring data")
                intent.putExtra("data2", "somestring data2")
                startActivity(intent)

            }
            R.id.btn_move_with_objek -> {
                var manusia = Person("Siti", "siti@gmail.com", "Malang", 17)
                val intent = Intent(this@MainActivity1, MainActivity5::class.java)
                intent.putExtra(MainActivity5.EXTRA_PERSON, manusia)
                startActivity(intent)
            }
        }
    }

}
