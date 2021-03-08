package fr.isen.boutellis.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ScoreActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score2)

        val score=intent.getStringExtra("score")
Log.d("from score",score.toString())
    }
}