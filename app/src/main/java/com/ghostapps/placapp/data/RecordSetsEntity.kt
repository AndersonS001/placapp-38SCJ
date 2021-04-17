package com.ghostapps.placapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.models.RecordSetModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordSetsEntity.TABLE_NAME)
class RecordSetsEntity(

    @PrimaryKey
    @SerializedName("timestamp")
    val timestamp: Long,

    val matchId: Long,

    val gameSetNumber: Int,

    val homeTeamPoints: Int,

    val awayTeamPoints: Int
) {

    companion object {
        const val TABLE_NAME = "records_set_match"


        fun listFromModel(recordModel: RecordModel): List<RecordSetsEntity> {
            val list: MutableList<RecordSetsEntity> = mutableListOf()

            recordModel.gameSetHistory!!.forEach {
                list.add(
                    RecordSetsEntity(
                        homeTeamPoints = it.homeTeamPoints,
                        awayTeamPoints = it.awayTeamPoints,
                        gameSetNumber = it.gameSetNumber,
                        matchId = it.matchId,
                        timestamp = it.timestamp
                    )
                )
            }

            return list
        }

        fun listToModel(setsEntity: List<RecordSetsEntity>): List<RecordSetModel> {
            val list: MutableList<RecordSetModel> = mutableListOf()

            setsEntity.forEach {
                list.add(
                    RecordSetModel(
                        homeTeamPoints = it.homeTeamPoints,
                        awayTeamPoints = it.awayTeamPoints,
                        matchId = it.matchId,
                        timestamp = it.timestamp,
                        gameSetNumber = it.gameSetNumber
                    )
                )
            }

            return list
        }

        fun fromModel(recordSetModel: RecordSetModel): RecordSetsEntity {
            return RecordSetsEntity(
                homeTeamPoints = recordSetModel.homeTeamPoints,
                awayTeamPoints = recordSetModel.awayTeamPoints,
                gameSetNumber = recordSetModel.gameSetNumber,
                matchId = recordSetModel.matchId,
                timestamp = recordSetModel.timestamp
            )
        }
    }


}
