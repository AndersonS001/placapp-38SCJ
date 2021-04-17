package com.ghostapps.placapp.data

import androidx.room.Embedded
import androidx.room.Relation
import com.ghostapps.placapp.domain.models.RecordModel

class MatchWithSets(

    @Embedded
    val match: RecordMatchEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "matchId"
    )
    val setHistory: List<RecordSetsEntity>
) {

    companion object {

    }

    fun toModel(): RecordModel {
        return RecordModel(
            homeTeamName = match.homeTeamName,
            homeTeamSetScore = match.homeTeamSetScore,

            awayTeamName = match.awayTeamName,
            awayTeamSetScore = match.awayTeamSetScore,

            gameSetHistory = RecordSetsEntity.listToModel(setHistory),

            id = match.id
        )
    }
}