package com.ghostapps.placapp.viewModel.preGame

import androidx.lifecycle.ViewModel

class PreGameViewModel(
    private val contract: PreGameContract
) : ViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    fun onStartGamePressed() {
        contract.goToGame()
    }

}