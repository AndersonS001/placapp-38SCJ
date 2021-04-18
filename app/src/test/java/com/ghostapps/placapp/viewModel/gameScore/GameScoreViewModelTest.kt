package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordSetModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.nhaarman.mockito_kotlin.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameScoreViewModelTest {

    private val gameScoreContractMock: GameScoreContract = mock {}
    private val insertRegisterMock: InsertRegister = mock {}

    private lateinit var sut: GameScoreViewModel

    @Before
    fun setup() {
        sut = GameScoreViewModel(gameScoreContractMock, insertRegisterMock)

        sut.onCreate(homeTeamName = "teamAName", awayTeamName = "teamBName", recordModel = null)
    }

    @Test
    fun `Should update team names correctly`() {
        val teamAName = "team_a"
        val teamBName = "team_b"

        sut.onCreate(homeTeamName = teamAName, awayTeamName = teamBName, recordModel = null)

        assertEquals(sut.homeTeam.teamName, teamAName)
        assertEquals(sut.awayTeam.teamName, teamBName)
    }

    @Test
    fun `Should increase home team score when onHomeTeamIncrease is called`() {
        sut.onHomeTeamIncrease()
        assertEquals(sut.homeTeam.formattedTeamScore, "01")

        sut.onHomeTeamIncrease()
        assertEquals(sut.homeTeam.formattedTeamScore, "02")
    }

    @Test
    fun `Should increase away team score when onAwayTeamIncrease is called`() {

        sut.onAwayTeamIncrease()
        assertEquals(sut.awayTeam.formattedTeamScore, "01")

        sut.onAwayTeamIncrease()
        assertEquals(sut.awayTeam.formattedTeamScore, "02")
    }

    @Test
    fun `Should call endSet`() {
        val teamA = Match()
        val teamB = Match()
        teamA.teamScore = 24
        teamB.teamScore = 23

        sut.onCreate(homeTeamMatch = teamA, awayTeamMatch = teamB, recordModel = null)
        sut.onHomeTeamIncrease()
    }

}