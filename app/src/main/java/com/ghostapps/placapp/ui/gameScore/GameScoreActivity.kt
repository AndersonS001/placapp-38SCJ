package com.ghostapps.placapp.ui.gameScore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghostapps.placapp.R
import com.ghostapps.placapp.databinding.ActivityScoreGameBinding
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameScoreActivity : AppCompatActivity(), GameScoreContract {

    companion object {
        const val TEAM_HOME_NAME = "home_team_name"
        const val TEAM_AWAY_NAME = "away_team_name"
        const val MATCH_ID = "match_id"
    }

    private lateinit var binding: ActivityScoreGameBinding
    private val viewModel: GameScoreViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score_game)
        binding.viewModel = viewModel

        viewModel.onCreate(
            intent.getStringExtra(TEAM_HOME_NAME) ?: "",
            intent.getStringExtra(TEAM_AWAY_NAME) ?: "",
            recordModel = intent.getParcelableExtra(MATCH_ID)
        )
    }

    override fun onExitPressed() {
        finish()
    }

}