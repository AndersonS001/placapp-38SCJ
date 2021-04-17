package com.ghostapps.placapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordMatchEntity.TABLE_NAME)
class RecordMatchEntity(

    @SerializedName("team_a_name")
    val homeTeamName: String,
    @SerializedName("team_a_score")
    val homeTeamSetScore: Int?,

    @SerializedName("team_b_name")
    val awayTeamName: String,
    @SerializedName("team_b_score")
    val awayTeamSetScore: Int?,

    @PrimaryKey(autoGenerate = true)
    @SerializedName("timestamp")
    val id: Long
) {

    companion object {
        const val TABLE_NAME = "records_match"

        fun fromModel(recordModel: RecordModel): RecordMatchEntity {

            return RecordMatchEntity(
                homeTeamName = recordModel.homeTeamName,
                homeTeamSetScore = recordModel.homeTeamSetScore,

                awayTeamName = recordModel.awayTeamName,
                awayTeamSetScore = recordModel.awayTeamSetScore,

                id = recordModel.id
            )
        }
    }
}