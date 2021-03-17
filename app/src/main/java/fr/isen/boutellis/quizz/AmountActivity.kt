package fr.isen.boutellis.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.boutellis.quizz.databinding.ActivityMainBinding
import fr.isen.boutellis.quizz.databinding.AmountBinding

class AmountActivity : AppCompatActivity() {
    private lateinit var binding: AmountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AmountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profileName=intent.getStringExtra("pseudo")
        val difficulty = intent.getStringExtra("diff")
        Log.d("from amount", profileName.toString())
        Log.d("from amount", difficulty.toString())

        binding.amountBtn.setOnClickListener {

if (binding.phone.text.toString().length>0) {
    val intent = Intent(this, QuizQuestionsActivity::class.java)
    intent.putExtra("diff", difficulty)
    intent.putExtra("pseudo", profileName)
    intent.putExtra("amount", binding.phone.text.toString())
    intent.putExtra("amountInt", binding.phone.text.toString().toInt())

    startActivity(intent)
}

        }





    }



}
