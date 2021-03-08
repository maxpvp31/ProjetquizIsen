package fr.isen.boutellis.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.isen.boutellis.quizz.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profileName=intent.getStringExtra("pseudo")
        val difficulty = intent.getStringExtra("diff")
        val amount = intent.getStringExtra("amount")
        Log.d("from quiez", profileName.toString())
        Log.d("from quiez", difficulty.toString())
        Log.d("from quiez",amount.toString())

    }


}