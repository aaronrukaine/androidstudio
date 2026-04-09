package com.aaron.simba_wellnessapp

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class MainActivity : AppCompatActivity() {
//    a variable to store the interstetial ad\
    private  var mInterstitialAd: InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//prepare your app to load ads
MobileAds.initialize(this)

        //        find view by id is to get the adview layout
        val adView=findViewById<AdView>(R.id.adView)
//        creates a request asking AdMob for an ad
        var adRequest= AdRequest.Builder().build()
//        sends the request to Admob
//        loads the ad
//        admob returns the add
        adView.loadAd(adRequest)


//        call the function to load the add\

        loadInterstitialAd()


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

            showInterstitialAd()
        }

//        nutrition content
        val nutrition=findViewById<Button>(R.id.advice)

        nutrition.setOnClickListener {

            val adviceIntent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(adviceIntent)
            showInterstitialAd()


        }

//        meditation

        val meditation=findViewById<Button>(R.id.meditation)

        meditation.setOnClickListener {
            val meditationIntent= Intent(applicationContext, Meditation::class.java)
            startActivity(meditationIntent)
            showInterstitialAd()
        }

//        hydration alert
        val hydrationAlert=findViewById<Button>(R.id.hydration)
        hydrationAlert.setOnClickListener {
            var hydrationIntent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(hydrationIntent)
            showInterstitialAd()
        }
//        weeklyview
        var weeklyGoals=findViewById<Button>(R.id.goals)
        weeklyGoals.setOnClickListener {
            var weeklyGoals= Intent( applicationContext,WeeklyGoals::class.java
            )
            startActivity(weeklyGoals)
            showInterstitialAd()
        }
//        check progress

        var checkProgress=findViewById<Button>(R.id.progress)
        checkProgress.setOnClickListener {
            var checkProgress= Intent(applicationContext,CheckProgress::class.java)
            startActivity(checkProgress)
            showInterstitialAd()
        }

        var startExercise=findViewById<Button>(R.id.exercise)
        startExercise.setOnClickListener {
            var startExercise= Intent(applicationContext, StartExercise::class.java)
            startActivity(startExercise)
            showInterstitialAd()
        }

        var dailyMotivation=findViewById<Button>(R.id.motivation)
        dailyMotivation.setOnClickListener {
            var dailyMotivation= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(dailyMotivation)
            showInterstitialAd()
        }}
        fun loadInterstitialAd() {
            val adRequest = AdRequest.Builder().build()

            InterstitialAd.load(
                this,
                "ca-app-pub-3940256099942544/1033173712", // Test ID
                adRequest,
                object : InterstitialAdLoadCallback() {

                    override fun onAdLoaded(ad: InterstitialAd) {
                        mInterstitialAd = ad
                    }

                    override fun onAdFailedToLoad(error: LoadAdError) {
                        mInterstitialAd = null
                    }
                }
            )
        }
        //Show Interstitial ad
        fun showInterstitialAd() {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            }
        }




    }
