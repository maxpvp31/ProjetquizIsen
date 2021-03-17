package fr.isen.boutellis.quizz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import fr.isen.boutellis.quizz.databinding.ActivityEasyQuestionsBinding.inflate

public class RecipeAdapter(private val context: Context,
                    private val dataSource: List<ScoreActivity2.FromDb>) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.activity_easy_questions,null , false)
        var titleTextView = rowView.findViewById(R.id.textView2) as TextView

// Get subtitle element
        var subtitleTextView = rowView.findViewById(R.id.textView3) as TextView
        var recipe = getItem(p0) as ScoreActivity2.FromDb

        titleTextView.text = recipe.pseudo
        subtitleTextView.text = recipe.score.toString() +'/' + recipe.amount.toString()


        return rowView
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]

    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}