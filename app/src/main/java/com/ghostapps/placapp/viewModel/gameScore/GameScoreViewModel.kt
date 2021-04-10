package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.viewModel.BaseViewModel

class GameScoreViewModel(
    private val contract: GameScoreContract
) : BaseViewModel() {

    var homeTeamScore = 0
    var awayTeamScore = 0

    var homeTeamName = ""
    var awayTeamName = ""

    var setHomeTeamScore = 0
    var setAwayTeamScore = 0

    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var formattedSetHomeTeamScore = "00"
    var formattedSetAwayTeamScore = "00"

    fun onCreate(homeTeamName: String, awayTeamName: String) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName
    }

    fun onHomeTeamIncrease() {
        homeTeamScore++
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeamScore++
        updateScore()
    }

    fun onExitPressed() {
        contract.onExitPressed()
    }

    private fun difference(x: Int, y: Int): Int {
        return x - y;
    }

    private fun updateScore() {
        formattedHomeTeamScore = String.format("%02d", homeTeamScore)
        formattedAwayTeamScore = String.format("%02d", awayTeamScore)

        updateSet()
    }

    private fun updateSet() {
        var setPoint = 25
        var isGameOver = false
        var winner = homeTeamName

        if (setHomeTeamScore == 2 && setAwayTeamScore == 2) {
            setPoint = 15
            isGameOver = true
        }

        if (homeTeamScore >= setPoint) {

            if (difference(homeTeamScore, awayTeamScore) >= 2) {
                setHomeTeamScore++
                formattedSetHomeTeamScore = setHomeTeamScore.toString()

                if (setHomeTeamScore == 3)
                    isGameOver = true

                resetScore()
            }
        }

        if (awayTeamScore >= setPoint) {

            if (difference(awayTeamScore, homeTeamScore) >= 2) {
                setAwayTeamScore++
                formattedSetAwayTeamScore = setAwayTeamScore.toString()

                if (setAwayTeamScore == 3) {
                    isGameOver = true
                    winner = awayTeamName
                }

                resetScore()
            }
        }

//        if(isGameOver) {
//            val text = "Fim de Jogo! O vencedor é: " + winner.text
//            val duration = Toast.LENGTH_LONG
//
//            val toast = Toast.makeText(applicationContext, text, duration)
//            toast.show()
//
//            onExitPressed()
//        }

        notifyChange()
    }

    private fun resetScore() {
        homeTeamScore = 0
        awayTeamScore = 0

        updateScore()
    }
}