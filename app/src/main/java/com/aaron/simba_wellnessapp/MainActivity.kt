package com.aaron.simba_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //finding ids using find view by id from thw layout
        //we are creating a variable to
        val recipe=findViewById<Button>(R.id.recipe)

        //set on click listener
        recipe.setOnClickListener {
            //enable our intent
            val recipeIntent= Intent(applicationContext,HealthyRecipes::class.java)
            startActivity(recipeIntent)
        }

//        nutrition content
        val nutrition=findViewById<Button>(R.id.advice)

        nutrition.setOnClickListener {

            val adviceIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(adviceIntent)


        }

//        meditation

        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {
            val nutritionIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(nutritionIntent)
        }

//        hydration alert
        val hydrationAlert=findViewById<Button>(R.id.hydration)
        hydrationAlert.setOnClickListener {
            var hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(hydrationIntent)
        }
//        weeklyview
        var weeklyGoals=findViewById<Button>(R.id.goals)
        weeklyGoals.setOnClickListener {
            var weeklyGoals= Intent( applicationContext,WeeklyGoals::class.java
            )
            startActivity(weeklyGoals)
        }
//        check progress

        var checkProgress=findViewById<Button>(R.id.progress)
        checkProgress.setOnClickListener {
            var checkProgress= Intent(applicationContext,CheckProgress::class.java)
            startActivity(checkProgress)
        }

        var startExercise=findViewById<Button>(R.id.exercise)
        startExercise.setOnClickListener {
            var startExercise= Intent(applicationContext, StartExercise::class.java)
            startActivity(startExercise)
        }

        var dailyMotivation=findViewById<Button>(R.id.motivation)
        dailyMotivation.setOnClickListener {
            var dailyMotivation= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(dailyMotivation)
        }




    }
}