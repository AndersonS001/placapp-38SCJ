package com.ghostapps.placapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_game.*

class GameScoreActivity: AppCompatActivity() {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
    }
    
    var homeTeamScore = 0
    private var awayTeamScore = 0

    var setHomeTeamScore = 0
    var setAwayTeamScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_game)

        gameScoreHomeTeamName.text = intent.getStringExtra(TEAM_HOME_NAME)
        gameScoreAwayTeamName.text = intent.getStringExtra(TEAM_AWAY_NAME)

        gameScoreHomeTeamScore.setOnClickListener {
            homeTeamScore++
            updateScore()
        }

        gameScoreAwayTeamScore.setOnClickListener {
            awayTeamScore++
            updateScore()
        }

        gameScoreExitButton.setOnClickListener {
            finish()
        }
    }
    
    private fun updateScore() {
        gameScoreHomeTeamScore.text = String.format("%02d", homeTeamScore)
        gameScoreAwayTeamScore.text = String.format("%02d", awayTeamScore)

        updateSet()
    }

    private fun resetScore(){
        homeTeamScore = 0
        awayTeamScore = 0

        updateScore()
    }

    private fun difference(x: Int, y: Int): Int{
        return  x - y;
    }

    private fun updateSet(){
        var setPoint = 25
        var isGameOver = false
        var winner = gameScoreHomeTeamName

        if(setHomeTeamScore == 2 && setAwayTeamScore == 2) {
            setPoint = 15
            isGameOver = true
        }

        if(homeTeamScore >= setPoint){

            if(difference(homeTeamScore,awayTeamScore) >= 2){
                setHomeTeamScore++
                gameScoreSetHomeTeamScore.text = setHomeTeamScore.toString()

                if(setHomeTeamScore == 3)
                    isGameOver = true

                resetScore()
            }
        }

        if(awayTeamScore >= setPoint){

            if(difference(awayTeamScore, homeTeamScore) >= 2){
                setAwayTeamScore++
                gameScoreSetAwayTeamScore.text = setAwayTeamScore.toString()

                if(setAwayTeamScore == 3) {
                    isGameOver = true
                    winner = gameScoreAwayTeamName
                }

                resetScore()
            }
        }

        if(isGameOver) {
            val text = "Fim de Jogo! O vencedor é: " + winner.text
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()

            finish()
        }
    }
}