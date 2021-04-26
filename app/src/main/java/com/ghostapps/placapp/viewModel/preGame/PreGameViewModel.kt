package com.ghostapps.placapp.viewModel.preGame

import androidx.lifecycle.ViewModel
import com.ghostapps.placapp.domain.models.RecordModel

class PreGameViewModel(
    private val contract: PreGameContract
) : ViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""
//    lateinit var record: RecordModel

    fun onStartGamePressed() {


        contract.goToGame()

//        Thread {
//            record = insertRegister.execute(
//                RecordModel(
//                    homeTeamName = homeTeamName,
//                    awayTeamName = awayTeamName,
//                    id = Date().time,
//
//                    awayTeamSetScore = null,
//                    homeTeamSetScore = null,
//                    gameSetHistory = null
//                )
//            )
//
//
//        }.start()
    }

}