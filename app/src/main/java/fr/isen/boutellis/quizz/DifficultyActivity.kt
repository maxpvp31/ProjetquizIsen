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

        binding.OptionOne.setOnClickListener {
            var btn: Button = binding.OptionOne as Button
            var res: String = btn.getText().toString()
            Log.d("string", res)


            val intent = Intent(this, AmountActivity::class.java)
            startActivity(intent)
        }

        binding.OptionTwo.setOnClickListener {

        }

        binding.OptionThree.setOnClickListener {

        }







    }



}