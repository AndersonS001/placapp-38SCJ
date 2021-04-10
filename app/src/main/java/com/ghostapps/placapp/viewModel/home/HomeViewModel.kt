package com.ghostapps.placapp.viewModel.home

import androidx.lifecycle.ViewModel
import com.ghostapps.placapp.ui.preGame.PreGameActivity

class HomeViewModel(
    private val contract: HomeContract
) : ViewModel() {
    fun onNewGamePressed() {
        contract.navigateTo(PreGameActivity::class.java)
    }

    fun onExitPressed() {
        contract.closeApp()
    }
}