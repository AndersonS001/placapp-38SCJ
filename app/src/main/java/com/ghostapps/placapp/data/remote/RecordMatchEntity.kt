package com.ghostapps.placapp.data.remote

import com.ghostapps.placapp.domain.models.RecordModel

class RecordMatchEntity(

    val homeTeamName: String = "",
    val homeTeamSetScore: Int? = 0,

    val awayTeamName: String = "",
    val awayTeamSetScore: Int? = 0,

    val gameSetList: List<RecordSetsEntity>? = null,

    val documentId: String = ""
) {


    companion object {
        const val COLLECTION_NAME = "records_match"

        fun toModel(recordMatchEntity: RecordMatchEntity, id: String): RecordModel {
            return RecordModel(
                homeTeamName = recordMatchEntity.homeTeamName,
                homeTeamSetScore = recordMatchEntity.homeTeamSetScore,

                awayTeamName = recordMatchEntity.awayTeamName,
                awayTeamSetScore = recordMatchEntity.awayTeamSetScore,
                gameSetHistory = RecordSetsEntity.listToModel(recordMatchEntity),

                documentId = id
            )
        }

        fun fromModel(recordModel: RecordModel): RecordMatchEntity {

            return RecordMatchEntity(
                homeTeamName = recordModel.homeTeamName,
                homeTeamSetScore = recordModel.homeTeamSetScore,

                awayTeamName = recordModel.awayTeamName,
                awayTeamSetScore = recordModel.awayTeamSetScore,

                gameSetList = RecordSetsEntity.listFromModel(recordModel)
            )
        }
    }

}