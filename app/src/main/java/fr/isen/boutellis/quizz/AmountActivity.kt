package fr.isen.boutellis.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.boutellis.quizz.databinding.ActivityMainBinding
import fr.isen.boutellis.quizz.databinding.AmountBinding

class AmountActivity : AppCompatActivity() {
    private lateinit var binding: AmountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AmountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SubmitButton.setOnClickListener {


            val intent = Intent(this, PseudoActivity::class.java)
            startActivity(intent)
        }





    }



}
