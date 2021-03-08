package fr.isen.boutellis.quizz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import fr.isen.boutellis.quizz.databinding.DifficultyBinding

class DifficultyActivity : AppCompatActivity() {
    private lateinit var binding: DifficultyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DifficultyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profileName=intent.getStringExtra("pseudo")
        Log.d("from Difficulty", profileName.toString())

        binding.easy.setOnClickListener {


            val intent = Intent(this, AmountActivity::class.java)
            intent.putExtra("diff","Easy")
            intent.putExtra("pseudo",profileName)

            startActivity(intent)
        }

        binding.medium.setOnClickListener {

            val intent = Intent(this, AmountActivity::class.java)
            intent.putExtra("diff","Medium")
            intent.putExtra("pseudo",profileName)
            startActivity(intent)
        }

        binding.hard.setOnClickListener {

            val intent = Intent(this, AmountActivity::class.java)
            intent.putExtra("diff","Hard")
            intent.putExtra("pseudo",profileName)

            startActivity(intent)
        }







    }



}