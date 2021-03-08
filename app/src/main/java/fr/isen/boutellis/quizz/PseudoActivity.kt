package fr.isen.boutellis.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.boutellis.quizz.databinding.ActivityEasyQuestionsBinding.inflate
import fr.isen.boutellis.quizz.databinding.ActivityMainBinding
import fr.isen.boutellis.quizz.databinding.ActivityPseudoBinding

class PseudoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPseudoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPseudoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Log.d("msg",binding.pseudoText.text.toString())


            val intent = Intent(this, DifficultyActivity::class.java)
            intent.putExtra("pseudo",binding.pseudoText.text.toString())
            startActivity(intent)
        }





    }



}
