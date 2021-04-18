package com.ghostapps.placapp.viewModel.gameScore

data class Match(
    var teamScore: Int = 0,

    var teamName: String = "",

    var gameSetTeamScore: Int = 0,

    var formattedTeamScore: String = "00",

    var formattedSetTeamScore: String = "0"
)
