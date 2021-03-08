package fr.isen.boutellis.quizz

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.isen.boutellis.quizz.databinding.ActivityQuizQuestionsBinding
import okhttp3.*

import java.io.IOException


class QuizQuestionsActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var data = null
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
        Log.d("from quiiiiez test url","https://opentdb.com/api.php?amount="+amount.toString()+"&category=9&difficulty="+difficulty.toString()+"&type=multiple")
        run("https://opentdb.com/api.php?amount="+amount.toString()+"&category=9&difficulty="+difficulty.toString()+"&type=multiple")

    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
               println(body)
                val gson = GsonBuilder().create()
                val t = Gson().fromJson(body,Student::class.java)
    println(t.results.get(0))
                val q = t.results.get(0).question
                binding.EasyQuestions.text = q.toString()
            }
        })
    }

    data class Student (
        var response_code: Int? ,
        var results: List<Result>
    ) {
    }
    data class Result (
        var category: String ,
        var type: String,
        var difficulty : String,
        var question : String,
        var correct_answer : String,
        var incorrect_answers : List<String>
    ) {
    }


}