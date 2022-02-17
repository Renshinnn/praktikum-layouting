package www.smktelkommlg.sch.id

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveSV: Button = findViewById(R.id.btn_move_sv)
        btnMoveSV.setOnClickListener(this)

    }
    override fun onClick(v: View){
        when (v.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_sv -> {
                val moveSV = Intent(this@MainActivity,MainActivity3::class.java)
                startActivity(moveSV)
            }
        }
    }

}
