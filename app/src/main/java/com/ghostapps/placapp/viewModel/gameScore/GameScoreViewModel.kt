package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.models.RecordSetModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(
    private val contract: GameScoreContract,
    private val insertRegister: InsertRegister
) : BaseViewModel() {

    var homeTeamScore = 0
    var awayTeamScore = 0

    var homeTeamName = ""
    var awayTeamName = ""

    var setHomeTeamScore = 0
    var setAwayTeamScore = 0

    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var formattedSetHomeTeamScore = "0"
    var formattedSetAwayTeamScore = "0"

    lateinit var recordMatch: RecordModel

    fun onCreate(homeTeamName: String, awayTeamName: String, recordModel: RecordModel?) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName

        if (recordModel != null) {
            this.recordMatch = recordModel
        }
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

    private fun endGame() {
        Thread {
            insertRegister.execute(
                RecordModel(
                    id = recordMatch.id,
                    homeTeamName = homeTeamName,
                    awayTeamName = awayTeamName,
                    homeTeamSetScore = setHomeTeamScore,
                    awayTeamSetScore = setAwayTeamScore,

                    gameSetHistory = null
                )
            )

            onExitPressed()
        }.start()
    }

    private fun endSet() {
        Thread {
            insertRegister.execute(
                RecordSetModel(
                    matchId = recordMatch.id,
                    timestamp = Date().time,
                    homeTeamPoints = homeTeamScore,
                    awayTeamPoints = awayTeamScore
                )
            )

            resetScore()
        }.start()
    }

    private fun updateSet() {
        var setPoint = 25
        var isGameOver = false

        if (setHomeTeamScore == 2 && setAwayTeamScore == 2) {
            setPoint = 15
        }

        if (homeTeamScore >= setPoint) {

            if (difference(homeTeamScore, awayTeamScore) >= 2) {
                setHomeTeamScore++
                formattedSetHomeTeamScore = setHomeTeamScore.toString()

                if (setHomeTeamScore == 3)
                    isGameOver = true

                endSet()
            }
        }

        if (awayTeamScore >= setPoint) {

            if (difference(awayTeamScore, homeTeamScore) >= 2) {
                setAwayTeamScore++
                formattedSetAwayTeamScore = setAwayTeamScore.toString()

                if (setAwayTeamScore == 3)
                    isGameOver = true

                endSet()
            }
        }

        if (isGameOver)
            endGame()

        notifyChange()
    }

    private fun resetScore() {
        homeTeamScore = 0
        awayTeamScore = 0

        updateScore()
    }
}