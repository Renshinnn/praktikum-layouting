package www.smktelkommlg.sch.id

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.smktelkommlg.sch.id.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    private lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email}, \nCity : ${person.city}, " +
                "Age : ${person.age}"
        binding.tvHasil.text = text
    }
}