package com.ghostapps.placapp.viewModel.preGame

import androidx.lifecycle.ViewModel
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import java.util.*

class PreGameViewModel(
    private val contract: PreGameContract,
    private val insertRegister: InsertRegister
) : ViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""
    lateinit var record : RecordModel

    fun onStartGamePressed() {

        Thread {
            record = insertRegister.execute(
                RecordModel(
                    homeTeamName = homeTeamName,
                    awayTeamName = awayTeamName,
                    id = Date().time,

                    awayTeamSetScore = null,
                    homeTeamSetScore = null,
                    gameSetHistory = null
                )
            )

            contract.goToGame()

        }.start()
    }

}