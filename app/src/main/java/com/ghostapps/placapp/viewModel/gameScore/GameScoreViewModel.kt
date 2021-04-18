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

    lateinit var homeTeam: Match
    lateinit var awayTeam: Match

    lateinit var recordMatch: RecordModel

    fun onCreate(homeTeamName: String, awayTeamName: String, recordModel: RecordModel?) {
        homeTeam = Match(teamName= homeTeamName)
        awayTeam = Match(teamName = awayTeamName)

        if (recordModel != null) {
            this.recordMatch = recordModel
        }
    }

    fun onCreate(homeTeamMatch: Match, awayTeamMatch: Match, recordModel: RecordModel?) {
        homeTeam = homeTeamMatch
        awayTeam = awayTeamMatch

        if (recordModel != null) {
            this.recordMatch = recordModel
        }
    }

    fun onHomeTeamIncrease() {
        homeTeam.teamScore++
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeam.teamScore++
        updateScore()
    }

    fun onExitPressed() {
        contract.onExitPressed()
    }

    private fun difference(x: Int, y: Int): Int {
        return x - y;
    }

    private fun updateScore() {
        homeTeam.formattedTeamScore = String.format("%02d", homeTeam.teamScore)
        awayTeam.formattedTeamScore = String.format("%02d", awayTeam.teamScore)

        updateSet()
    }

    private fun endGame() {
        Thread {
            insertRegister.execute(
                RecordModel(
                    id = recordMatch.id,
                    homeTeamName = homeTeam.teamName,
                    awayTeamName = awayTeam.teamName,
                    homeTeamSetScore = homeTeam.gameSetTeamScore,
                    awayTeamSetScore = awayTeam.gameSetTeamScore,

                    gameSetHistory = null
                )
            )
        }.start()

    }

    private fun endSet(gameSetNumber: Int) {
        Thread {
            insertRegister.execute(
                RecordSetModel(
                    matchId = recordMatch.id,
                    timestamp = Date().time,
                    homeTeamPoints = homeTeam.teamScore,
                    awayTeamPoints = awayTeam.teamScore,
                    gameSetNumber = gameSetNumber
                )
            )

            resetScore()
        }.start()
    }

    private fun updateSet() {
        var gameSetPoint = 25

        if (homeTeam.gameSetTeamScore == 2 && awayTeam.gameSetTeamScore == 2) {
            gameSetPoint = 15
        }

        val homeGameOver = gameSetPoint(homeTeam, awayTeam, gameSetPoint)

        val awayGameOver = gameSetPoint(awayTeam, homeTeam, gameSetPoint)

        if (homeGameOver || awayGameOver) {
            endGame()

            onExitPressed()
        }

        notifyChange()
    }

    private fun gameSetPoint(match: Match, otherTeam: Match, setPoint: Int): Boolean {

        var isGameOver = false

        if (match.teamScore >= setPoint) {

            if (difference(match.teamScore, otherTeam.teamScore) >= 2) {
                match.gameSetTeamScore++
                match.formattedSetTeamScore = match.gameSetTeamScore.toString()

                if (match.gameSetTeamScore == 3)
                    isGameOver = true

                endSet(gameSetNumber = otherTeam.gameSetTeamScore + match.gameSetTeamScore)
            }
        }

        return isGameOver
    }

    private fun resetScore() {
        homeTeam.teamScore = 0
        awayTeam.teamScore = 0

        updateScore()
    }
}