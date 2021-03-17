package fr.isen.boutellis.quizz

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class ScoreActivity2 : AppCompatActivity() {
    private lateinit var listView : ListView
    private val client = OkHttpClient()
    private  var url : String = "https://havephone.fr/api/v1/quiz"
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score2)

        createNotif()
        val score=intent.getStringExtra("score")
        val amount = intent.getStringExtra("amount")

        Log.d("from score",score.toString())


        sendNotif(score.toString(),amount.toString())
        run(url)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotif(){
        val name = "Notification Title"
        val descriptionText = "Notification description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID,name,importance).apply{
            description = descriptionText

        }

        val notifManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notifManager.createNotificationChannel(channel)
    }

    private fun sendNotif(param : String,amount : String){
        val builder = NotificationCompat.Builder(this,CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_foreground).
        setContentTitle("Félicitations vous avez terminé le quiz !").
        setContentText("Votre score est de "+ param +"/"+amount).setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId,builder.build())
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
                Log.d("piste tes morts",body.toString())
                val t = Gson().fromJson(body,arrDB ::class.java)
                val q = t.resultat.get(0).pseudo
                println(q)


                runOnUiThread{
        val adapter = RecipeAdapter(this@ScoreActivity2,t.resultat)
                    listView = findViewById<ListView>(R.id.listViewQuiz)

                    listView.adapter = adapter
                }


            }
        })
    }
data class arrDB (
    var resultat : List<FromDb>
){

}
    data class FromDb (
            var id: Int ,
            var pseudo: String,
            var score : Int,
            var amount : Int

    ) {


    }
}





