package fr.isen.boutellis.quizz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import fr.isen.boutellis.quizz.databinding.ActivityQuizQuestionsBinding
import okhttp3.*


import java.io.IOException
import kotlin.random.Random.Default.Companion


class QuizQuestionsActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var data : List<Result> = listOf()
    private var compteur : Int = 0
    private var score : Int = 0
    private var amountToSend : String = ""
    private var progressBar : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profileName=intent.getStringExtra("pseudo")
        val difficulty = intent.getStringExtra("diff")
        val amount = intent.getStringExtra("amount")
        amountToSend = amount.toString()
        run("https://opentdb.com/api.php?amount="+amount.toString()+"&category=9&difficulty="+difficulty.toString()+"&type=multiple")

        binding.btn1.setOnClickListener {
            checkAnswer(binding.btn1.text.toString())
            quizHandler()
        }
        binding.btn2.setOnClickListener {
            checkAnswer(binding.btn2.text.toString())
            quizHandler()
        }
        binding.btn3.setOnClickListener {
            checkAnswer(binding.btn3.text.toString())
            quizHandler()
        }
        binding.btn4.setOnClickListener {
            checkAnswer(binding.btn4.text.toString())
            quizHandler()
        }


    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}

            override fun onResponse(call: Call, response: Response) {
               val body = response?.body()?.string()
                val t = Gson().fromJson(body,Student::class.java)
                val q = t.results.get(0).question

                data = t.results
                println(data)
              runOnUiThread{
                  binding.EasyQuestions.text = q
                  binding.btn1.text = t.results[0].correct_answer
                  binding.btn2.text =  t.results[0].incorrect_answers[0]
                  binding.btn3.text =  t.results[0].incorrect_answers[1]
                  binding.btn4.text =  t.results[0].incorrect_answers[2]


              }


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

    fun checkAnswer(str : String){
        println(str)
        println(data[compteur].correct_answer)
        if (str==data[compteur].correct_answer){
            score+=1

        println(score)

    }
        binding.ProgressBar.progress+=1

    }
   fun quizHandler(){


        compteur++
       if(compteur==data.size){

           val intent = Intent(this, ScoreActivity2::class.java)
           intent.putExtra("score",score.toString())
           intent.putExtra("amount",amountToSend)

           startActivity(intent)
       }else{
           runOnUiThread{
               binding.EasyQuestions.text = data[compteur].question
               binding.btn1.text = data[compteur].correct_answer
               binding.btn2.text =  data[compteur].incorrect_answers[0]
               binding.btn3.text =  data[compteur].incorrect_answers[1]
               binding.btn4.text =  data[compteur].incorrect_answers[2]
           }
       }


    }

    fun sendToDb(){
        val payload = "ee"
        val requestBody  : RequestBody = RequestBody.create(JSON,payload)
        val request = Request.Builder()
                .method("POST", requestBody)
                .url("url")
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Handle this
            }

            override fun onResponse(call: Call, response: Response) {
                // Handle this
            }
        })
    }


}